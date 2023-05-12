import java.util.Arrays;

class Solution {
    public int getFst (int num) {
        while(num >= 10) {
            num /= 10;
        }
        return num;
    }
    public int getRes (int o1, int o2) {
        int num = o2;
        int tmp = o1;
        while (num > 0) {
            tmp *= 10;
            num /= 10;
        }
        tmp += o2;
        return tmp;
    }
    public String solution(int[] numbers) {
        Integer[] numArr = new Integer[numbers.length];
        int idx = 0;
        for(int num : numbers)
            numArr[idx++] = num;
        Arrays.sort(numArr, (o1, o2) -> {
            if(getFst(o1) != getFst(o2))
                return getFst(o2) - getFst(o1);
            int tmp1 = getRes(o1, o2);
            int tmp2 = getRes(o2, o1);
            return tmp2 - tmp1;
        });
        String answer = "";
        for(int num : numArr) {
            String tmp = Integer.toString(num);
            if(answer.length() == 0 || answer.charAt(0) != '0' || num != 0)
                answer += tmp;
        }
        return answer;
    }
}