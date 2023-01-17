import java.util.Scanner;

//집합의 표현

public class Main {
	static int[] add;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();		
		
		add = new int[N+1];
		
		for(int n = 0; n < N+1; n++) {
			add[n] = n;
		}
		
		for(int m = 0; m < M; m++) {
			int todo = sc.nextInt();
			int numA = sc.nextInt();
			int numB = sc.nextInt();
			
			if(todo == 0) {
				union(numA, numB);
			}
			else {
				check(numA, numB);
			}
		}
	}
	
	static void union (int numA, int numB) {
		numA = findparent(numA);
		numB = findparent(numB);
		if(numA < numB )add[numB] = numA;
		else add[numA] = numB;
	}
	
	static void check (int numA, int numB) {
		numA = findparent(numA);
		numB = findparent(numB);
		
		if(numA == numB) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	static int findparent(int num) {
		if (add[num] == num)
			return num;
		else
			return add[num] = findparent(add[num]);
	}
}
