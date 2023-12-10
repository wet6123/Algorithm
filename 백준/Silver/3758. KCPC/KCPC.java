import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Comparator<log> comparator = new Comparator<log>() {
        	public int compare(log a, log b) {
        		if (a.grade == b.grade) {
        			if (a.cnt == b.cnt) {
        				return a.time - b.time;
        			}
        			return a.cnt - b.cnt;
        		}
        		return b.grade - a.grade;
        	}
        };
        
        int T = Integer.parseInt(st.nextToken());
        for(int x = 0; x < T; x++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][][] team = new int[n][k][3];
            
            for(int y = 1; y <= m; y++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if (team[i - 1][j - 1][0] < s)
                	team[i - 1][j - 1][0] = s;
                team[i - 1][j - 1][1]++;
                team[i - 1][j - 1][2] = y;
            }

            int[] grade = new int[n];
            int[] cnt = new int[n];
            int[] time = new int[n];
            List<log> logs = new ArrayList<>();
            for(int a = 0; a < n; a++) {
            	for(int b = 0; b < k; b++) {
//            		점수
        			grade[a] += team[a][b][0];
//        			제출횟수
    				cnt[a] += team[a][b][1];
//        			제출 시각
    				if(time[a] < team[a][b][2])
    				time[a] = team[a][b][2];
            	}
//            	bw.write((a + 1) + " " + grade[a] + " " + cnt[a] + " " + time[a] + "\n");
            	logs.add(new log(a + 1, grade[a], cnt[a], time[a]));
            }
            Collections.sort(logs, comparator);
            int ranking = 1;
            while(!logs.isEmpty()) {
            	if(logs.remove(0).num == t) {
            		bw.write(ranking + "\n");
            		break;
            	}
            	ranking++;
            }
        }
        bw.close();
    }
    static class log {
    	int num;
    	int grade;
    	int cnt;
    	int time;
    	
    	log(int num, int grade, int cnt, int time) {
    		this.num = num;
    		this.grade = grade;
    		this.cnt = cnt;
    		this.time = time;
    	}
    }
}