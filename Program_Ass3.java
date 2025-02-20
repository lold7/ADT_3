import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program_Ass3 {

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedStack<T> {
        private Node<T> top;
        private int size;

        public LinkedStack() {
            top = null;
            size = 0;
        }

        public void push(T value) {
            Node<T> newNode = new Node<>(value);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow - attempt to pop from an empty stack.");
            }
            T value = top.data;
            top = top.next;
            size--;
            return value;
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Cannot peek from an empty stack.");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        File file = new File("input1.csv");

       
        if (!file.exists()) {
            System.out.println("Error: 'input1.csv' was not found in the current directory.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            int expressionNumber = 1;
            while (scanner.hasNextLine()) {
                String infixExpression = scanner.nextLine().trim();

                System.out.println("Expression " + expressionNumber + ":");
                System.out.println("Infix exp: " + infixExpression);

                
                if (isValidInfix(infixExpression)) {
                    System.out.println("Valid");
                  
                    String postfix = convertInfixToPostfix(infixExpression);
                    System.out.println("Postfix exp: " + postfix);
                } else {
                    System.out.println("Not-Valid");
                }

                System.out.println(); 
                expressionNumber++;
            }
        } catch (FileNotFoundException e) {
            
            System.out.println("Error: Unable to open 'input1.csv'.");
        }
    }

   
    private static boolean isValidInfix(String expr) {
        
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if (top != '(') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            
            return false;
        }

       
        for (int i = 0; i < expr.length() - 1; i++) {
            char current = expr.charAt(i);
            char next = expr.charAt(i + 1);
            if (isOperator(current) && isOperator(next)) {
              
                return false;
            }
        }

        
        char firstChar = expr.charAt(0);
        char lastChar = expr.charAt(expr.length() - 1);

      
        if (isOperator(firstChar) && firstChar != '(' && firstChar != '-' && firstChar != '+') {
            return false;
        }
 
        if (isOperator(lastChar) && lastChar != ')') {
            return false;
        }

        return true;
    }

 
    private static String convertInfixToPostfix(String expr) {
        StringBuilder postfix = new StringBuilder();
        LinkedStack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

           
            if (isOperand(c)) {
                postfix.append(c);
            }
           
            else if (c == '(') {
                stack.push(c);
            }
            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            
            else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(' 
                       && hasHigherPrecedence(stack.peek(), c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
           
        }

       
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    
    private static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    
    private static boolean hasHigherPrecedence(char op1, char op2) {
        int p1 = getPrecedence(op1);
        int p2 = getPrecedence(op2);

        
        if (p1 == p2) {
            
            if (op1 == '^') {
                return false; 
            }
            
            return true;
        }

        return p1 > p2;
    }

    
    private static int getPrecedence(char op) {
        switch (op) {
            case '^': return 3; 
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return -1; 
    }
}



