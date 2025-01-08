import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int ansStart = 0;
        int ansEnd = 0;
        
        for(String key : gems) {
            map.put(key, 0);
        }
        
        int start = 0;
        int end = 0;
        int cnt = 0;
        int size = map.size();
        
        while (end < gems.length) {
            String key = gems[end];
            if (map.get(key) == 0)
                cnt++;
            map.put(key, map.get(key) + 1);
            while (cnt == size) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    ansStart = start;
                    ansEnd = end;
                    if (min == map.size())
                        return new int[] {ansStart + 1, ansEnd + 1};
                }
                key = gems[start];
                map.put(key, map.get(key) - 1);
                if (map.get(key) <= 0)
                    cnt--;
                start++;
            }
            end++;
        }
        
        return new int[] {ansStart + 1, ansEnd + 1};
    }
}