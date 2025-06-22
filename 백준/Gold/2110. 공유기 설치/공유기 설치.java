import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[] houses;
    static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N-1] - houses[0];
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canPlaceRouters(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        bw.write(answer + "");
        bw.close();
    }

    public static boolean canPlaceRouters(int minDistance) {
        int count = 1;
        int lastPosition = houses[0];
        
        for (int i = 1; i < N; i++) {
            if (houses[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = houses[i];
                
                if (count == C) {
                    return true;
                }
            }
        }
        
        return false;
    }
}