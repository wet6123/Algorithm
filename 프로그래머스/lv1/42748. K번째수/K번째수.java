import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int[] arr = new int[end - start + 1];
            for(int j = 0;j < end - start + 1; j++) {
                arr[j] = array[j + start - 1];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        return answer;
    }
}