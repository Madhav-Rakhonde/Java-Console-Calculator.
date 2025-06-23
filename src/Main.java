import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int operationCount = 0;

    public static void main(String[] args) {
        boolean running = true;

        // Welcome message with better formatting
        printWelcomeMessage();

        while (running) {
            try {
                Calculator.showMenu();
                System.out.print("👉 Enter your choice (1-9): ");

                int choice = getValidInteger(1, 9);

                if (choice == -1) {
                    continue; // Invalid input, show menu again
                }

                running = handleUserChoice(choice);

            } catch (Exception e) {
                System.out.println("❌ An unexpected error occurred: " + e.getMessage());
                System.out.println("🔄 Restarting calculator...");
                // Clear any remaining input
                scanner.nextLine();
            }
        }

        scanner.close();
        printGoodbyeMessage();
    }

    private static void printWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  🧮 Welcome to Java Advanced Console Calculator! 🧮  ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  💡 Features:                                        ║");
        System.out.println("║    • Supports decimal numbers (e.g., 3.14)          ║");
        System.out.println("║    • Supports scientific notation (e.g., 1.5e10)    ║");
        System.out.println("║    • Comprehensive error handling                    ║");
        System.out.println("║    • User-friendly interface                         ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    private static void printGoodbyeMessage() {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║          📊 Session Summary               ║");
        System.out.println("╠═══════════════════════════════════════════╣");
        System.out.printf("║  Total calculations performed: %-10d ║%n", operationCount);
        System.out.println("║  Thank you for using Java Calculator!    ║");
        System.out.println("║  👋 Goodbye and have a great day! 🌟     ║");
        System.out.println("╚═══════════════════════════════════════════╝");
    }

    private static boolean handleUserChoice(int choice) {
        try {
            switch (choice) {
                case 1: case 2: case 3: case 4: case 5: case 6:
                    return handleTwoNumberOperation(choice);
                case 7:
                    return handleSquareRoot();
                case 8:
                    handleClearScreen();
                    return true;
                case 9:
                    return handleExit();
                default:
                    System.out.println("❌ Invalid choice. Please select between 1 and 9.");
                    return true;
            }
        } catch (ArithmeticException e) {
            System.out.println("⚠️  Math Error: " + e.getMessage());
            System.out.println("💡 Tip: Check your input values and try again.");
            return askToRetry();
        } catch (Exception e) {
            System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            return askToRetry();
        }
    }

    private static boolean handleTwoNumberOperation(int choice) {
        String operationName = getOperationName(choice);
        System.out.println("\n🔢 " + operationName + " Operation");
        System.out.println("─".repeat(30));

        System.out.print("Enter first number: ");
        double num1 = getValidDouble();

        System.out.print("Enter second number: ");
        double num2 = getValidDouble();

        // Show calculation being performed
        String symbol = Calculator.getOperationSymbol(choice);
        System.out.println("\n🔄 Calculating: " + formatNumber(num1) + " " + symbol + " " + formatNumber(num2));

        double result = performOperation(choice, num1, num2);
        String formattedResult = Calculator.formatResult(result);

        // Display result in a nice box
        displayResult(formatNumber(num1), symbol, formatNumber(num2), formattedResult);

        operationCount++;
        return askToContinue();
    }

    private static boolean handleSquareRoot() {
        System.out.println("\n🔢 Square Root Operation");
        System.out.println("─".repeat(30));

        System.out.print("Enter number: ");
        double num = getValidDouble();

        System.out.println("\n🔄 Calculating: √" + formatNumber(num));

        double result = Calculator.squareRoot(num);
        String formattedResult = Calculator.formatResult(result);

        // Display result in a nice box
        displaySquareRootResult(formatNumber(num), formattedResult);

        operationCount++;
        return askToContinue();
    }

    private static void handleClearScreen() {
        Calculator.clearScreen();
        System.out.println("✨ Screen cleared successfully!");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private static boolean handleExit() {
        System.out.print("\n🤔 Are you sure you want to exit? (y/n): ");
        String response = getValidYesNo();

        if (response.equals("yes")) {
            return false; // Exit the program
        } else {
            System.out.println("🔄 Returning to calculator...");
            return true; // Continue running
        }
    }

    private static void displayResult(String num1, String symbol, String num2, String result) {
        int maxWidth = Math.max(Math.max(num1.length() + symbol.length() + num2.length() + 4, result.length() + 9), 25);
        String border = "─".repeat(maxWidth + 4);

        System.out.println("\n┌" + border + "┐");
        System.out.printf("│  ✨ RESULT: %-" + (maxWidth - 10) + "s │%n", "");
        System.out.println("├" + border + "┤");
        System.out.printf("│  %s %s %s = %s%-" + (maxWidth - (num1.length() + symbol.length() + num2.length() + result.length() + 3)) + "s │%n",
                num1, symbol, num2, result, "");
        System.out.println("└" + border + "┘");
    }

    private static void displaySquareRootResult(String num, String result) {
        int maxWidth = Math.max(Math.max(num.length() + 3, result.length() + 9), 25);
        String border = "─".repeat(maxWidth + 4);

        System.out.println("\n┌" + border + "┐");
        System.out.printf("│  ✨ RESULT: %-" + (maxWidth - 10) + "s │%n", "");
        System.out.println("├" + border + "┤");
        System.out.printf("│  √%s = %s%-" + (maxWidth - (num.length() + result.length() + 4)) + "s │%n",
                num, result, "");
        System.out.println("└" + border + "┘");
    }

    private static double performOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1: return Calculator.add(num1, num2);
            case 2: return Calculator.subtract(num1, num2);
            case 3: return Calculator.multiply(num1, num2);
            case 4: return Calculator.divide(num1, num2);
            case 5: return Calculator.modulus(num1, num2);
            case 6: return Calculator.power(num1, num2);
            default: throw new IllegalArgumentException("Invalid operation choice: " + choice);
        }
    }

    private static String getOperationName(int choice) {
        switch (choice) {
            case 1: return "Addition";
            case 2: return "Subtraction";
            case 3: return "Multiplication";
            case 4: return "Division";
            case 5: return "Modulus";
            case 6: return "Power";
            default: return "Unknown";
        }
    }

    private static String formatNumber(double number) {
        if (number == Math.floor(number) && Math.abs(number) < 1e15) {
            return String.format("%.0f", number);
        } else {
            String formatted = String.format("%.10f", number);
            formatted = formatted.replaceAll("0+$", "").replaceAll("\\.$", "");
            return formatted;
        }
    }

    private static boolean askToContinue() {
        System.out.print("\n🔄 Would you like to perform another calculation? (y/n): ");
        String response = getValidYesNo();

        if (response.equals("no")) {
            return false; // Exit the program
        }

        System.out.println(); // Add spacing before next operation
        return true; // Continue running
    }

    private static boolean askToRetry() {
        System.out.print("\n🔄 Would you like to try this operation again? (y/n): ");
        String response = getValidYesNo();

        return response.equals("yes");
    }

    private static String getValidYesNo() {
        while (true) {
            try {
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.isEmpty()) {
                    System.out.print("Please enter 'y' for yes or 'n' for no: ");
                    continue;
                }

                if (input.equals("y") || input.equals("yes")) {
                    return "yes";
                } else if (input.equals("n") || input.equals("no")) {
                    return "no";
                } else {
                    System.out.print("Invalid input. Please enter 'y' for yes or 'n' for no: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter 'y' for yes or 'n' for no: ");
            }
        }
    }

    private static int getValidInteger(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                    continue;
                }

                // Handle potential whitespace or extra characters
                input = input.split("\\s+")[0]; // Take only the first part before any space

                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.print("⚠️  Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input. Please enter a valid number: ");
            } catch (Exception e) {
                System.out.print("❌ Error reading input. Please try again: ");
            }
        }
    }

    private static double getValidDouble() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.print("Please enter a valid number: ");
                    continue;
                }

                // Handle potential whitespace or extra characters
                input = input.split("\\s+")[0]; // Take only the first part before any space

                double value = Double.parseDouble(input);

                if (Double.isNaN(value)) {
                    System.out.print("❌ Invalid number. Please enter a valid number: ");
                    continue;
                }

                // Check for extremely large numbers that might cause issues
                if (Math.abs(value) > 1e308) {
                    System.out.print("⚠️  Number too large. Please enter a smaller number: ");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input. Please enter a valid number (e.g., 3.14, 1.5e10): ");
            } catch (Exception e) {
                System.out.print("❌ Error reading input. Please try again: ");
            }
        }
    }
}