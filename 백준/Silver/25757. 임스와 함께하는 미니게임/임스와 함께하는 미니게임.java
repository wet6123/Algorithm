import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int cnt = map.size() + 1;
            map.put(name, cnt);
        }
        int ans = map.size();
        if(game.equals("F")) {
        	ans /= 2;
        } else if (game.equals("O")) {
        	ans /= 3;
        }
        bw.write(ans + "");
        bw.close();
    }
}