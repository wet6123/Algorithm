import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String[] str = new String[N];
        int[][] arr = new int[N][26];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            for(int j = 0; j < str[i].length(); j++) {
                int tmp = str[i].charAt(j) - 'A';
                arr[i][tmp]++;
            }
        }
        
        boolean[] composition = new boolean[N];
        
        int ans = 0;
        
        for(int i = 1; i < N; i++) {
        	composition[i] = true;
        	int cnt1 = 0;
        	int cnt2 = 0;
        	for(int j = 0; j < 26; j++) {
        		if (arr[i][j] != arr[0][j]) {
        			composition[i] = false;
        			if (arr[i][j] > arr[0][j]) {
        				cnt1 += arr[i][j] - arr[0][j];
        			}
        			if (arr[i][j] < arr[0][j]) {
        				cnt2 += arr[0][j] - arr[i][j];
        			}
        		}
        	}
        	if((!composition[i] && cnt1 <= 1 && cnt2 <= 1) || composition[i])
        		ans++;
        }
        bw.write(ans + "\n");
        bw.close();
    }
}