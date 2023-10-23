import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.length() >= M) {
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        
        Collections.sort(keySet);

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	if(map.get(o1) != map.get(o2))
            		return map.get(o2).compareTo(map.get(o1));
            	else if(o1.length() != o2.length())
            		return o2.length() - o1.length();
            	else
            		return 0;
            }
        });

        for (String key : keySet) {
            bw.write(key + "\n");
        }
        
        bw.close();
    }
}