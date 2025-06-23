# 🧮 Java Advanced Console Calculator

A feature-rich, user-friendly console-based calculator application built in Java with comprehensive error handling, beautiful UI, and advanced mathematical operations.

## 📋 Table of Contents

- [Features](#-features)
- [Screenshots](#-screenshots)
- [Installation](#-installation)
- [Usage](#-usage)
- [Operations Supported](#-operations-supported)
- [File Structure](#-file-structure)
- [Technical Details](#-technical-details)
- [Error Handling](#-error-handling)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features

### 🎨 **User Interface**
- Beautiful Unicode box borders and professional formatting
- Colorful emoji indicators for better user experience
- Interactive menu system with clear navigation
- Session summary with operation tracking
- Cross-platform screen clearing functionality

### 🔢 **Mathematical Operations**
- **Basic Operations**: Addition, Subtraction, Multiplication, Division
- **Advanced Operations**: Modulus, Power, Square Root
- **Number Format Support**: 
  - Decimal numbers (e.g., 3.14159)
  - Scientific notation (e.g., 1.5e10, 2.3e-5)
  - Very large and very small numbers
  - Automatic result formatting (removes unnecessary decimals)

### 🛡️ **Robust Error Handling**
- Division by zero protection
- Invalid input validation
- Overflow and underflow detection
- Mathematical impossibilities (e.g., square root of negative numbers)
- Graceful error recovery with retry options
- No crashes under any input conditions

### 💡 **Smart Features**
- Input validation with helpful prompts
- Operation confirmation and retry options
- Flexible yes/no input handling
- Progress indicators during calculations
- Professional result display boxes
- Session statistics tracking

## 📸 Screenshots

```
![Screenshot 2025-06-23 135148](https://github.com/user-attachments/assets/7a15683b-87d1-42bb-8686-da73821771c1)
![Uploading Screenshot 2025-06-23 135206.png…]()


```

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

### Steps
1. **Clone or Download** the repository:
   ```bash
   git clone https://github.com/yourusername/java-calculator.git
   cd java-calculator
   ```

2. **Compile** the Java files:
   ```bash
   javac *.java
   ```

3. **Run** the calculator:
   ```bash
   java Main
   ```

### Alternative: Direct Download
1. Download `Calculator.java` and `Main.java`
2. Place both files in the same directory
3. Follow steps 2-3 above

## 🎯 Usage

### Basic Operations
1. **Start the Calculator**: Run `java Main`
2. **Choose Operation**: Enter a number (1-9) from the menu
3. **Enter Numbers**: Follow the prompts to enter your numbers
4. **View Result**: The result will be displayed in a formatted box
5. **Continue or Exit**: Choose to perform another calculation or exit

### Input Examples
```bash
# Decimal numbers
Enter first number: 3.14159
Enter second number: 2.71828

# Scientific notation
Enter first number: 1.5e10
Enter second number: 2.3e-5

# Large numbers
Enter first number: 999999999999999
Enter second number: 0.000001
```

### Sample Session
```
🔢 Addition Operation
──────────────────────────────

Enter first number: 15.75
Enter second number: 24.25

🔄 Calculating: 15.75 + 24.25

┌─────────────────────────────────────┐
│  ✨ RESULT:                         │
├─────────────────────────────────────┤
│  15.75 + 24.25 = 40                │
└─────────────────────────────────────┘

🔄 Would you like to perform another calculation? (y/n): 
```

## 🔧 Operations Supported

| Operation | Symbol | Description | Example |
|-----------|--------|-------------|---------|
| Addition | + | Adds two numbers | `5 + 3 = 8` |
| Subtraction | - | Subtracts second from first | `10 - 4 = 6` |
| Multiplication | × | Multiplies two numbers | `6 × 7 = 42` |
| Division | ÷ | Divides first by second | `15 ÷ 3 = 5` |
| Modulus | % | Remainder after division | `17 % 5 = 2` |
| Power | ^ | Raises first to power of second | `2 ^ 3 = 8` |
| Square Root | √ | Square root of number | `√25 = 5` |

### Special Cases Handled
- **Division by Zero**: Returns error with helpful message
- **Square Root of Negative**: Returns error with explanation
- **Power Edge Cases**: Handles 0^negative, infinity, etc.
- **Very Large Numbers**: Detects overflow and infinity
- **Invalid Operations**: Clear error messages with retry options



### Calculator.java
- **Mathematical Operations**: All calculation methods
- **Utility Functions**: Formatting, screen clearing, menu display
- **Error Handling**: Arithmetic exception throwing
- **Result Formatting**: Smart number formatting

### Main.java
- **User Interface**: Menu system and user interaction
- **Input Validation**: Robust input handling and validation
- **Program Flow**: Main application loop and navigation
- **Session Management**: Operation counting and statistics

## 🔧 Technical Details

### System Requirements
- **Java Version**: JDK 8+
- **Memory**: Minimal (< 50MB)
- **OS Support**: Windows, macOS, Linux
- **Terminal**: Any standard command line interface

### Key Technical Features
- **Exception Safety**: No uncaught exceptions
- **Memory Management**: Proper resource cleanup
- **Cross-Platform**: Works on all major operating systems
- **Input Robustness**: Handles malformed input gracefully
- **Precision**: Uses Java's double precision for calculations

### Performance Characteristics
- **Startup Time**: < 1 second
- **Calculation Speed**: Instant for all operations
- **Memory Usage**: Constant, no memory leaks
- **Scalability**: Handles numbers up to Double.MAX_VALUE

## 🛡️ Error Handling

### Input Validation
- **Empty Input**: Prompts for valid input
- **Invalid Characters**: Clear error messages
- **Out of Range**: Helpful range guidance
- **Malformed Numbers**: Specific format examples

### Mathematical Errors
- **Division by Zero**: "Cannot divide by zero. Please enter a non-zero divisor"
- **Negative Square Root**: "Cannot find square root of a negative number"
- **Overflow**: "Result is too large to represent"
- **Invalid Power**: "Cannot raise zero to a negative power"

### Recovery Options
- **Retry Operation**: Option to retry failed operations
- **Continue Session**: Continue with new operations after errors
- **Graceful Exit**: Clean program termination at any time

## 🤝 Contributing

We welcome contributions! Here's how you can help:

### Ways to Contribute
1. **Bug Reports**: Report issues with detailed reproduction steps
2. **Feature Requests**: Suggest new mathematical operations or UI improvements
3. **Code Contributions**: Submit pull requests with improvements
4. **Documentation**: Help improve this README or add code comments

### Contribution Guidelines
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Code Style
- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Include error handling for new features
- Maintain backward compatibility

## 📊 Future Enhancements

### Planned Features
- [ ] **Calculation History**: Save and recall previous calculations
- [ ] **Memory Functions**: Store and recall values (M+, M-, MR, MC)
- [ ] **Advanced Functions**: Trigonometric functions (sin, cos, tan)
- [ ] **Expression Parser**: Support for complex expressions like "2 + 3 * 4"
- [ ] **Unit Conversions**: Length, weight, temperature conversions
- [ ] **Graphical Interface**: Optional GUI version
- [ ] **Configuration File**: Customizable settings and preferences

### Technical Improvements
- [ ] **Logging System**: Add comprehensive logging
- [ ] **Unit Tests**: Complete test coverage
- [ ] **Performance Optimization**: Faster large number operations
- [ ] **Internationalization**: Multi-language support







## 🌟 Acknowledgments

- **Java Community**: For excellent documentation and support
- **Unicode Consortium**: For beautiful box-drawing characters
- **Contributors**: All developers who have contributed to this project
- **Users**: Thank you for using and providing feedback

---

**Made with ❤️ by the Java Calculator Team**

*Happy Calculating! 🧮✨*
