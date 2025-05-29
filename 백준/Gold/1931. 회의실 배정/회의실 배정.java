import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }
        
        Arrays.sort(meetings, (a, b) -> {
            if (a.end == b.end) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });
        
        int count = 0;
        int lastEndTime = 0;
        
        for (int i = 0; i < n; i++) {
            if (meetings[i].start >= lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }
        
        bw.write(count + "");        
        bw.close();
    }
    
    static class Meeting {
        int start, end;
        
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}