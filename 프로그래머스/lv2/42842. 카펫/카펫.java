class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yellowY = 1;
        int brownX;
        
        while(yellowY <= yellow/yellowY) {
            brownX = yellow/yellowY + 2;
            if((brownX + yellowY) * 2 == brown) {
                answer[0] = brownX;
                answer[1] = yellowY + 2;
            }
            yellowY++;
        }
        
        return answer;
    }
}