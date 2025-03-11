class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        
        int start = 0;
        int end = 0;
        
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> current = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            required.put(c, required.getOrDefault(c, 0) + 1);
            current.put(c, 0);
        }
        
        String ans = "";
        boolean found = false;
        
        while(end < s.length()) {
            char currentChar = s.charAt(end);
            
            if(required.containsKey(currentChar)) {
                current.put(currentChar, current.get(currentChar) + 1);
            }
            
            while(start <= end && checkCnt(current, required)) {
                if(!found || end - start + 1 < ans.length()) {
                    found = true;
                    ans = s.substring(start, end + 1);
                }
                
                char startChar = s.charAt(start);
                if(required.containsKey(startChar)) {
                    current.put(startChar, current.get(startChar) - 1);
                }
                start++;
            }
            end++;
        }
        
        return found ? ans : "";
    }
    
    public static boolean checkCnt(HashMap<Character, Integer> current, HashMap<Character, Integer> required) {
        for(Character key : required.keySet()) {
            if(current.get(key) < required.get(key)) {
                return false;
            }
        }
        return true;
    }
}