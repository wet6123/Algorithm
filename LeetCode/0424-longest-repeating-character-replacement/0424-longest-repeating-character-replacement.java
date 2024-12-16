class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 1;  // 1로 초기화
        int right = s.length();
        int left = 1;  // k가 아닌 1부터 시작
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (can_find(mid, s, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public boolean can_find(int size, String s, int k) {
        if (size > s.length()) return false;
        
        int[] cnt = new int[26];
        int maxCount = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < size; i++) {
            cnt[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, cnt[s.charAt(i) - 'A']);
        }
        
        if (maxCount + k >= size) return true;

        // 슬라이딩 윈도우
        for (int i = size; i < s.length(); i++) {
            cnt[s.charAt(i - size) - 'A']--;
            cnt[s.charAt(i) - 'A']++;
            
            // 최대 카운트 업데이트
            maxCount = 0;
            for (int j = 0; j < 26; j++) {
                maxCount = Math.max(maxCount, cnt[j]);
            }
            
            if (maxCount + k >= size) return true;
        }
        
        return false;
    }
}