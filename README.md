# Count Program
- Author:  Anawat Jandee
- Student ID:  672115049<br><br>
A Programming Assignment in ADT & Solving Problem course that reads a text file (my_txt.txt) and performs various text-processing operations such as counting characters, detecting palindromes, tokenizing words, identifying emoticons, and finding the longest token in the text.
---

## Description
This program reads infix expressions from a file named input1.csv in the same directory, checks whether each expression is valid, and if valid, converts it to postfix notation. The program uses:

1. A Node class to represent nodes in a singly-linked list.
2. A LinkedStack class, which uses the Node class to implement the stack functionality.
3. An infix-to-postfix converter that follows a standard algorithm using stack operations.


## Table of Contents
- [Installation](#installation)
- [Usage and Output](#usage-and-output)
- [Features](#features)

## Installation
1. Save the source code in a file named `Program_Ass3.java` and `input1.csv`.
2. Prepare a `Program_Ass3.java` file with student data. Ensure the data follows the correct format.
3. Run the Java program on cross-platform code editor such as:
   ```bash
   Visual Studio Code
   ```

## Usage and Output
To use the program, follow these steps:

Run the program in your terminal.

Example interaction
```bash
Expression 1:
Infix exp: a-b/(c+d-e)*(f^g*h+i)
Valid
Postfix exp: abcd+e-/fg^h*i+*-

Expression 2:
Infix exp: 1+2+3^4**
Not-Valid

```

---

## Features
- **Balanced Parentheses Checking**: Uses a stack-based method to ensure each ( has a matching ).
- **Operator Checking**: Detects invalid consecutive operators like ++, **, // (except special handling for ^ if needed).
- **Start/End Validation**: Rejects expressions that start or end with disallowed operators.
- **Linked-List-Based Stack**: Demonstrates how to create a custom data structure instead of using Java’s built-in Stack or ArrayList.
- **Handles Basic Operators**: +, -, *, /, and ^ (power).
- **Automatic File Reading**: Always attempts to open input1.csv (no command-line arguments needed).
- **Graceful Error Handling**: Prints an error if the file is missing or if invalid expressions are encountered.


# THANK YOU
---
