import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("!@#$%^&*(\\\'\"<>?:;");
        bw.close();
    }
}