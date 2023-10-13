import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int startIndex = 0;
	static int endIndex = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int[] stack = new int[com];
		StringBuilder sb =  new StringBuilder();

		
		for (int i = 0; i < com; i++) {
//			System.out.println("지금 start = "+startIndex);
//			System.out.println("지금 end = "+endIndex);
//			System.out.println("---------");
			String command = br.readLine();
			if (command.contains("push")) {
				String strnum = command.replaceAll("[^\\d]","");
				int num = Integer.parseInt(strnum);
				push(stack,num);
				
			} else if (command.equals("front")) {
				sb.append(front(stack)).append("\n");
				
			} else if (command.equals("size")) {
				sb.append(size(stack)).append("\n");
			} else if (command.equals("pop")) {
				sb.append(pop(stack)).append("\n");
			} else if (command.equals("empty")){
				sb.append(isEmpty(stack)).append("\n");
			}else if (command.equals("back")) {
				sb.append(back(stack)).append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void push(int[] stack, int num) {
		stack[++endIndex] = num;
	}

	public static int pop(int[] stack) {
		if(endIndex==-1) {
			
			return -1;
			
		}else {
			
			int rem = stack[startIndex];
			
			if(startIndex==endIndex) {
				endIndex=-1;
				startIndex=-1;
//			}else if(startIndex!=endIndex-1) {
//				endIndex--;
			}
			startIndex++;
			return rem;
			
		}
	}

	public static int size(int[] stack) {
		if (endIndex==-1) {
			return 0;
		}
		return endIndex-startIndex+1;
	}

	public static int isEmpty(int[] stack) {
		if(endIndex==-1) {
			return 1;
		}else {
			return 0;
		}
	}

	public static int front(int[] stack) {
		if(endIndex==-1) {
			return -1;
		}else {
			
			return stack[startIndex];
		}
	}
	
	public static int back(int[] stack) {
		if(endIndex == -1) {
			return -1;
		}else {
			return stack[endIndex];
		}
	}
}
