import java.io.*;
import java.util.*;

public class Main {
	static String[] title;
	static int[] num;
	static int target;
	static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        title = new String[N];
        num = new int[N];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	title[cnt] = st.nextToken();
        	num[cnt] = Integer.parseInt(st.nextToken());
        	if (cnt > 0 && num[cnt - 1] == num[cnt]) {
        		cnt--;
        	}
        	cnt++;
        }
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	target = Integer.parseInt(st.nextToken());
        	binary(0, cnt - 1);
        	bw.write(title[idx] + "\n");
        }
        bw.close();
    }
    public static void binary(int start, int end) {
    	if (start > end) {
    		idx = start;
    		return;
    	}
    	int mid = (start + end) / 2;
    	if ((mid > 0 && (num[mid - 1] < target && target <= num[mid])) || (mid == 0 && (0 <= target && target <= num[mid]))) {
    		idx = mid;
    		return;
    	} else if (mid > 0 && target <= num[mid - 1]) {
    		binary(start, mid - 1);
    	} else {
    		binary(mid + 1, end);    		
    	}
    }
}