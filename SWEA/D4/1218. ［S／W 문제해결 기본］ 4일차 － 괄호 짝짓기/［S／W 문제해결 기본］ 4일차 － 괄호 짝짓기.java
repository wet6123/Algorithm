import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

//[S/W 문제해결 기본] 4일차 - 괄호 짝짓기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 10; tc++) {
			int num = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			int idx = 0;
			
			int flag = 1;
			while(idx < num) {
				char now = str.charAt(idx++);
				if(now == '(' || now == '{' || now == '[')
					stack.push(now);
				else if(now == ')') {
					if(stack.pop() != '(') {
						flag = 0;
						break;
					}
				}
				else if(now == '}') {
					if(stack.pop() != '{') {
						flag = 0;
						break;
					}
				}
				else if(now == ']') {
					if(stack.pop() != '[') {
						flag = 0;
						break;
					}
				}
			}
            if (num % 2 != 0)
                flag = 0;
			System.out.println("#" + (tc+1) + " " + flag);
		}
	}
}
