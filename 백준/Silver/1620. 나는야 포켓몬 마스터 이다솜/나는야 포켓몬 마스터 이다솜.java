
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int lc = sc.nextInt();
        int pc = sc.nextInt();
        
        Map<Integer, String> list = new HashMap();
        Map<String, Integer> keys = new HashMap();
        for(int i = 0; i <= lc; i++) {
            String line = sc.nextLine();
            list.put(i, line);
            keys.put(line, i);
        }
        for(int i = 0; i < pc; i++) {
            String tmp = sc.nextLine();
            if(isStringNumber(tmp)) {
                sb.append(list.get(Integer.parseInt(tmp)));
            }
            else {
                sb.append(keys.get(tmp));
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}