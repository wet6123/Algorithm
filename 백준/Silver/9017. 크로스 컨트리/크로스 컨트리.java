import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            
            int[] check = new int[201];
            int[] numbers = new int[N];
            
            int[] sum = new int[201];
            int[] fifth = new int[201];
            int[] cnt = new int[201];
            int score = 1;
            
            for(int j = 0; j < N; j++) {
            	numbers[j] = Integer.parseInt(st.nextToken());
            	check[numbers[j]]++;
            }
            
            for(int j = 0; j < N; j++) {
            	int num = numbers[j];
                
                
                if(check[num] >= 6) {
                	cnt[num]++;
	                if(cnt[num] <= 4)
	                    sum[num] += score;
	                else if(cnt[num] == 5)
	                    fifth[num] = score;
	                score++;
                }
            }
            
            int min = Integer.MAX_VALUE;
            int min_fifth = 0;
            int team = 0;
            
            for(int j = 1; j <= 200; j++) {                
                if(cnt[j] == 6) {
                    if((sum[j] < min) || (sum[j] == min && fifth[j] < min_fifth)) {
                        min = sum[j];
                        team = j;
                        min_fifth = fifth[j];                        
                    }
                }
            }
            bw.write(team + "\n");
        }
        bw.close();
    }
}