public class Calculator {

    // Addition
    public static double add(double a, double b) {
        double result = a + b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large to represent");
        }
        return result;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        double result = a - b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large to represent");
        }
        return result;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        double result = a * b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large to represent");
        }
        return result;
    }

    // Division with zero check
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero. Please enter a non-zero divisor");
        }
        double result = a / b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large to represent");
        }
        return result;
    }

    // Modulus
    public static double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot perform modulus by zero. Please enter a non-zero divisor");
        }
        return a % b;
    }

    // Power
    public static double power(double base, double exponent) {
        // Handle special cases
        if (base == 0 && exponent < 0) {
            throw new ArithmeticException("Cannot raise zero to a negative power");
        }

        double result = Math.pow(base, exponent);

        if (Double.isNaN(result)) {
            throw new ArithmeticException("Invalid power operation (result is undefined)");
        }
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large to represent");
        }

        return result;
    }

    // Square root
    public static double squareRoot(double number) {
        if (number < 0) {
            throw new ArithmeticException("Cannot find square root of a negative number. Please enter a non-negative number");
        }
        return Math.sqrt(number);
    }

    // Enhanced clear screen that works on most systems
    public static void clearScreen() {
        try {
            // Try to clear screen using system commands
            final String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;

            if (os.contains("windows")) {
                pb = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                pb = new ProcessBuilder("clear");
            }

            Process process = pb.inheritIO().start();
            process.waitFor();

        } catch (Exception e) {
            // Fallback to printing empty lines
            System.out.print("\033[2J\033[H"); // ANSI escape codes for clearing
            System.out.flush();

            // If ANSI doesn't work, use line printing
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // Display menu with better formatting
    public static void showMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║        Java Advanced Console Calculator       ║");
        System.out.println("╠═══════════════════════════════════════════════╣");
        System.out.println("║  1. Addition (+)           5. Modulus (%)     ║");
        System.out.println("║  2. Subtraction (-)        6. Power (^)       ║");
        System.out.println("║  3. Multiplication (*)     7. Square Root (√) ║");
        System.out.println("║  4. Division (/)           8. Clear Screen    ║");
        System.out.println("║                            9. Exit            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    // Get operation symbol for display
    public static String getOperationSymbol(int choice) {
        switch (choice) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "×";
            case 4: return "÷";
            case 5: return "%";
            case 6: return "^";
            case 7: return "√";
            default: return "";
        }
    }

    // Format result for better display
    public static String formatResult(double result) {
        // Handle special cases
        if (Double.isNaN(result)) {
            return "Undefined";
        }
        if (Double.isInfinite(result)) {
            return result > 0 ? "Infinity" : "-Infinity";
        }

        // If result is a whole number, display without decimals
        if (result == Math.floor(result) && Math.abs(result) < 1e15) {
            return String.format("%.0f", result);
        } else {
            // Format with appropriate precision
            String formatted = String.format("%.10f", result);
            // Remove trailing zeros after decimal point
            formatted = formatted.replaceAll("0+$", "");
            // Remove trailing decimal point if no fractional part
            formatted = formatted.replaceAll("\\.$", "");
            return formatted;
        }
    }
}