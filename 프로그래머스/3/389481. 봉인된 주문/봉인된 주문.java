import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        List<Long> banNumbers = new ArrayList<>();
        for (String ban : bans) {
            banNumbers.add(convertFromBase26(ban));
        }
        
        Collections.sort(banNumbers);
        
        for (Long banNumber : banNumbers) {
            if (banNumber <= n) {
                n++;
            }
        }
        
        return convertToBase26String(n);
    }
    
    private String convertToBase26String(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long remainder = (n - 1) % 26;
            char ch = (char)('a' + remainder);
            sb.insert(0, ch);
            n = (n - 1) / 26;
        }
        
        return sb.toString();
    }
    
    private long convertFromBase26(String s) {
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}