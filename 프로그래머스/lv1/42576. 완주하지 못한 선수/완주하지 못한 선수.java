import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = completion.length;
        
        for(String one : participant) {
            if (map.get(one) == null)
                map.put(one, 1);
            else 
                map.put(one, map.get(one) + 1);
        }
        for(String one : completion) {
                map.put(one, map.get(one) - 1);
        }
        for(String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}