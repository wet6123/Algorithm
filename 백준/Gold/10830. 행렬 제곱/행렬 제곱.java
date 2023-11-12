import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][][] arr;
	static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int cnt = (int) (Math.log(B) / Math.log(2)) + 1;
        int[] binary = new int[cnt];
        int idx = 0;
        
        long tmp = B;
        while(tmp > 0){
            binary[idx] = (int) (tmp % 2);
            tmp = tmp / 2;
            idx++;
        }
        
        arr = new int[N][N][cnt];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		arr[i][j][0] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int ex = 1; ex < cnt; ex++) {
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			arr[i][j][ex] = calc(i, j, ex - 1) % 1000;
        		}
        	}
        }
        
        ans = new int[N][N];
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(i == j)
        			ans[i][j] = 1;
        		else
        			ans[i][j] = 0;
        	}
        }

        int[][] next = new int[N][N];
        for(int bin = 0; bin < cnt; bin++) {
        	if(binary[bin] == 1) {
        		for(int i = 0; i < N; i++) {
        			for(int j = 0; j < N; j++) {
    					next[i][j] = calc_arr(i, j, bin) % 1000;
	        		}
	        	}
        		for(int i = 0; i < N; i++) {
        			for(int j = 0; j < N; j++) {
        				ans[i][j] = next[i][j];
	        		}
	        	}
        	}
        }
        for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
				bw.write(ans[i][j] + " ");
    		}
    		bw.write("\n");
    	}
        bw.close();
    }
    static int calc(int i, int j, int ex) {
    	int ans = 0;
    	
    	for(int n = 0; n < N; n++) {
    		int tmp = 1;
    		tmp *= arr[i][n][ex] * arr[n][j][ex];
    		ans += tmp;
    	}
    	
		return ans;
    }
    static int calc_arr(int i, int j, int ex) {
    	int now_ans = 0;
    	
    	for(int n = 0; n < N; n++) {
    		int tmp = 1;
    		tmp *= ans[i][n] * arr[n][j][ex];
    		now_ans += tmp;
    	}
    	
		return now_ans;
    }
}