import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int[] heights = new int[n];
        for(int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(st.nextToken());
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            
            while (!stack.isEmpty() && (heights[stack.peek()]) < currentHeight) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result.append("0 ");
            } else {
                result.append((stack.peek() + 1) + " ");
            }
            
            stack.push(i);
        }
        
        bw.write(result.toString().trim());
        bw.close();
    }
}