import java.util.*;
import java.io.*;

class Main {
    public static class Node {
        int time;
        int score;
 
        public Node(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
 
        Node[] node = new Node[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            node[i] = new Node(k, s);
        }
 
        int[][] dp = new int[n + 1][t + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= t; j++) {
                if(node[i].time <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - node[i].time] + node[i].score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][t]);
    }
}