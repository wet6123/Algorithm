import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true)
        {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            //check end
            if(a == 0 && b == 0 && c == 0)
                break;
            
            //check valid triangle
            if(a + b <= c || a + c <= b || b + c <= a)
            {
                bw.write("Invalid\n");
                continue;
            }
        
            //check triangle type
            if(a == b && a == c && b == c)
                bw.write("Equilateral\n");
            else if(a == b || a == c || b == c)
                bw.write("Isosceles\n");
            else
                bw.write("Scalene\n");
        }
        bw.close();
    }
}