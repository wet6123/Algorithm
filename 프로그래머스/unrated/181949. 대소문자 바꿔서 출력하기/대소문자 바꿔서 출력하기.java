import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String str = st.nextToken();
        int len = str.length();
        
        int i = 0;
        while(i < len){
            if (str.charAt(i) < 'a') {
                bw.write(str.charAt(i) + 'a' - 'A');
            } else {
                bw.write(str.charAt(i) - 'a' + 'A');
            }
            i++;
        }
        bw.close();
    }
}