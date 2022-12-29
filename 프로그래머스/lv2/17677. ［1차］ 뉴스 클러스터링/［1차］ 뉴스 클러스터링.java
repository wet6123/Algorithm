import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        String tmpStr = str1.toUpperCase();
        List<String> set1 = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            if(checkChar(tmpStr.charAt(i)) && checkChar(tmpStr.charAt(i+1))){
                set1.add(tmpStr.substring(i, i+2));
            }
        }
        
        tmpStr = str2.toUpperCase();
        List<String> set2 = new ArrayList<>();
        
        for(int i = 0; i < str2.length() - 1; i++){
            if(checkChar(tmpStr.charAt(i)) && checkChar(tmpStr.charAt(i+1))){
                set2.add(tmpStr.substring(i, i+2));
            }
        }
        
        if(set1.size() == 0 && set2.size() == 0){
            answer = 65536;
        }else{
            float inter = 0;
            float union = set1.size() + set2.size();
            for(String str: set2){
                if(set1.contains(str)){
                    set1.remove(str);
                    inter++;
                }
            }
            
            union -= inter;
            answer = (int)Math.floor(inter/union*65536);
        }
        
        return answer;
    }
    static boolean checkChar(char target){
        if(target >= 65 && target <= 90){
            return true;
        }else{
            return false;
        }
    }
}