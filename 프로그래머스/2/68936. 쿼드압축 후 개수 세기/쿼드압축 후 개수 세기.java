class Solution {
    public int[] solution(int[][] arr) {
        return compression(arr, arr.length);
    }
    
    private int[] compression(int[][] arr, int len) {
        int sum = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                sum += arr[i][j];
            }
        }
        
        if (sum == 0) return new int[] {1, 0};
        if (sum == len * len) return new int[] {0, 1};
        
        int[] res = new int[2];
        int halfLen = len / 2;
        int[][] maps = {
            compression(makeArr(arr, 0, 0, halfLen), halfLen),
            compression(makeArr(arr, halfLen, 0, halfLen), halfLen),
            compression(makeArr(arr, 0, halfLen, halfLen), halfLen),
            compression(makeArr(arr, halfLen, halfLen, halfLen), halfLen),
        };

        
        for(int[] map : maps) {
            res[0] += map[0];
            res[1] += map[1];
        };
        
        return res;
    }
    
    private int[][] makeArr(int[][] arr, int xStart, int yStart, int len) {
        int[][] res = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                res[i][j] = arr[xStart + i][yStart + j];
            }
        }
        
        return res;
    }
}
