import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int lenFirst = 5;
        int lenSecond = 8;
        int lenThird = 10;
        
        int len = answers.length;
        int[] ans = new int[3];
        
        for(int i = 0; i < len; i++) {
            if(answers[i] == first[i%lenFirst])
                ans[0]++;
            if(answers[i] == second[i%lenSecond])
                ans[1]++;
            if(answers[i] == third[i%lenThird])
                ans[2]++;
        }
        
        int max = 0;
        Queue<Integer> res = new LinkedList<>();
        for(int i = 0; i < 3; i++) {
            if(max < ans[i]){
                res.clear();
                res.add(i);
                max = ans[i];
            } else if (max == ans[i])
                res.add(i);
        }
        
        int[] answer = new int[res.size()];
        int i = 0;
        for(Integer number : res)
            answer[i++] = number + 1;
        return answer;
    }
}