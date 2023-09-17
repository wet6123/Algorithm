import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        String[] vowel = {"a", "e", "i", "o", "u"};
        
        while(true) {
        	st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            boolean acceptable = true;
                        
            if (input.equals("end")) {
                bw.close();
                break;
            }
            
            //모음 확인
            int vowelCheck = 0;
            for(int i = 0; i < vowel.length; i++) {
                if(input.contains(vowel[i])) {
                	vowelCheck++;
                }
            }
            if(vowelCheck == 0) {
            	acceptable = false;
            }
            //자음, 모음 3글자 연속 확인
            int cnt = 0;
            boolean bfIsVowel = false;
            boolean isVowel = false;
            for(int i = 0; i < input.length(); i++) {
                for(int j = 0; j < vowel.length; j++) {
                    if(input.charAt(i) == vowel[j].charAt(0)) {
                    	isVowel = true;
                    	break;
                    } else {
                    	isVowel = false;
                    }
                }
                if(i == 0) {
                	cnt = 1;
                	bfIsVowel = isVowel;
                	continue;
                }
                
                if(bfIsVowel == isVowel) {
                	cnt++;
                } else {
                	cnt = 1;
                }
                
                bfIsVowel = isVowel;
                
                if(cnt == 3) {
                    acceptable = false;
                    break;
                }
            }
            //같은 글자 연속 확인 (ee, oo 제외)
            char before = 0;
            for(int i = 0; i < input.length(); i++) {
                if(before - input.charAt(i) == 0) {
                     if(input.charAt(i) - 'e' != 0 && input.charAt(i) - 'o' != 0) {
                         acceptable = false;
                         break;
                     }
                }
                before = input.charAt(i);
            }
            //결과 출력
            bw.write("<" + input + "> is ");
            if(!acceptable) {
                bw.write("not ");
            }
            bw.write("acceptable.\n");
        }
    }
}