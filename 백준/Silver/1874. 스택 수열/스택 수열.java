import java.util.Scanner;
import java.util.Stack;

//스택 수열
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> num = new Stack<>();
		Stack<Integer> tmp = new Stack<>();
		Stack<String> ans = new Stack<>();
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
			tmp.add(sc.nextInt());
		int cnt = N;
		while(cnt > 0) {
			int now = tmp.pop();
			num.push(now);
			ans.push("-");
			cnt--;
			while(N == now) {
				num.pop();
				ans.push("+");
				N--;
				if(!num.isEmpty())
					now = num.peek();
				else
					break;
			}
		}
		if(N == 0) {
			while(!ans.isEmpty()) {
				System.out.println(ans.pop());
			}
		} else {
			System.out.println("NO");
		}
	}
}
