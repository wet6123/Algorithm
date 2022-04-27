import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//프린터 큐
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int order = -1;
			
			Queue<Integer> queue = new LinkedList<>();
			Integer[] arr = new Integer[N];
			
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(i == M) {
					order = num;
					queue.add(0);
				} else {
					queue.add(num);
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				int num = queue.poll();
				if(num > order) {
					cnt++;
				}
				if(num != 0)
					arr[i] = num - order;
				else
					arr[i] = 0;
				queue.add(num);
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			int ans = 0;
			while(cnt > ans) {
				int num = queue.poll();
				if(arr[ans] != num - order)
					queue.add(num);
				else {
					ans++;
				}
			}
			while(!queue.isEmpty()) {
				int num = queue.poll();
				if(num == 0) {
					break;
				} else if(num == order) {
					ans++;
				} else if(num < order) {
					queue.add(num);
				}
			}
			System.out.println(ans+1);
		}
	}
}
