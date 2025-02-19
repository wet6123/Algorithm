class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = 1;
        while (i < digits.length && digits[i-1] <= digits[i]) {
            i++;
        }

        if (i == digits.length) {
            return n;
        }

        while (i > 0 && i < digits.length && digits[i-1] > digits[i]) {
            digits[i-1]--;
            i--;
        }

        for (int j = i + 1; j < digits.length; j++) {
            digits[j] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}