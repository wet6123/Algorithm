import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String expression = br.readLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char ch : expression.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    int currentPriority = (ch == '+' || ch == '-') ? 1 : 2;
                    int stackPriority = (stack.peek() == '+' || stack.peek() == '-') ? 1 : 2;
                    
                    if (stackPriority >= currentPriority) {
                        result.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        bw.write(result.toString());
        bw.close();
    }
}