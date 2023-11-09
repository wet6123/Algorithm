import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[20001];
        int center = 0;
        int left = 0;
        int right = 0;
        int idx = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[num + 10000]++;
            if (i == 0) {
                center = num + 10000;
            } else {
                if (center < num + 10000) {
                    right++;
                } else if(center > num + 10000) {
                    left++;
                } else {
                    right++;
                }
                if (right - left > 1) {
                    if (arr[center] == idx) {
                    	center++;
                        while(arr[center] < 1) {
                        	center++;
                        }
                        idx = 1;
                    } else {
                        idx++;
                    }
                    right--;
                    left++;
                }
                if (left > right) {
                    if (idx == 1) {
                    	center--;
                        while(arr[center] < 1) {
                        	center--;
                        }
                        idx = arr[center];
                    } else {
                        idx--;
                    }
                    right++;
                    left--;
                }
            }
            bw.write((center - 10000) + "\n");
        }
        bw.close();
    }
}