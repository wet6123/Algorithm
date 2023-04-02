import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//카드2
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> card = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			card.add(i);
		}
		while(!card.isEmpty()) {
			if(card.size() == 1) {
				System.out.println(card.poll());
			} else {
				card.poll();
				card.add(card.poll());
			}
		}
	}
}
