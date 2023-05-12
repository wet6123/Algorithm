import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        Integer[] arrR = new Integer[len];
        Integer[] arrC = new Integer[len];
        for(int i = 0; i < len; i++) {
            int row = sizes[i][0];
            int col = sizes[i][1];
            if(col > row) {
                arrR[i] = col;
                arrC[i] = row;
            } else {
                arrR[i] = row;
                arrC[i] = col;
            }
        }
        Arrays.sort(arrR, (o1, o2) -> o2 - o1);
        Arrays.sort(arrC, (o1, o2) -> o2 - o1);
        
        int answer = arrR[0] * arrC[0];
        return answer;
    }
}