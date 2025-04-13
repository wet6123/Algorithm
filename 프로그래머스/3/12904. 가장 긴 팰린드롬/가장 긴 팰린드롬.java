class Solution
{
    static int len;
    static char[] str;
    public int solution(String s)
    {
        len = s.length();
        if (s == null || len < 1) return 0;
        str = new char[len];
        for(int i = 0; i < len; i++) {
            str[i] = s.charAt(i);
        }
        
        int start = 0, end = 0;
        
        for(int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(i, i);
            int len2 = expandAroundCenter(i, i + 1);
            
            int max = Math.max(len1, len2);
            
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }

        return end - start + 1;
    }
    
    public int expandAroundCenter(int left, int right) {
        while (left >= 0 && right < len && str[left] == str[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}