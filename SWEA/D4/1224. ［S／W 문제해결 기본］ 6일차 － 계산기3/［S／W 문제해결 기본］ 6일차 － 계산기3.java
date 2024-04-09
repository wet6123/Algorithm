import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            String input = sc.next();
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            
            for(int i = 0; i < N; i++)
            {
                char now = input.charAt(i);
                if (now >= '0' && now <= '9')
                {
                    sb.append(now);
                }
                else if (now == '(')
                {
                    stack.push(now);
                }
                else if (now == ')')
                {
                    while(stack.peek() != '(')
                    {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                else if (stack.isEmpty())
                {
                    stack.push(now);
                }
                else if (now == '+')
                {
                    while(stack.peek() == '*' || stack.peek() == '+')
                    {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                }
                else if (now == '*')
                {
                    while(stack.peek() == '*')
                    {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                }
            }
            while(stack.isEmpty() == false)
            {
                sb.append(stack.pop());
            }
            
            String RPN = sb.toString(); 
            Stack<Integer> cal_stack = new Stack<>();
            int len = RPN.length();
            
            for(int i = 0; i < len; i++)
            {
                char now = RPN.charAt(i);
                if (now >= '0' && now <= '9')
                {
                    cal_stack.push(now - '0');
                }
                else
                {
                    int num1 = cal_stack.pop();
                    int num2 = cal_stack.pop();
                    int result;
                    if (now == '+')
                    {
                        result = num1 + num2;
                    }
                    else
                    {
                        result = num1 * num2;
                    }
                    cal_stack.push(result);
                }
            }
            
            int ans = cal_stack.pop();
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}