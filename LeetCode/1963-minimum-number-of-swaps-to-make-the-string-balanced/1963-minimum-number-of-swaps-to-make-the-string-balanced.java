class Solution {
    public int minSwaps(String s) {
        char[] str = s.toCharArray();
        int openingCnt = 0;
        int closingCnt = 0;
        int lastOpeningIdx = str.length - 1;
        int ans = 0;

        for(char letter : str) {
            if (letter == '[') {
                openingCnt++;
            } else {
                closingCnt++;
            }
            if (openingCnt < closingCnt) {
                while (str[lastOpeningIdx] == ']')
                    lastOpeningIdx--;
                openingCnt++;
                closingCnt--;
                str[lastOpeningIdx] = ']';
                ans++;
            }
        }

        return ans;
    }
}