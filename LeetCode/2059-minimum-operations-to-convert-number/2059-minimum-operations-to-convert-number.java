class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                if (curr == goal) {
                    return steps;
                }
                
                if (curr < 0 || curr > 1000) {
                    continue;
                }
                
                if (!visited.add(curr)) {
                    continue;
                }
                
                for (int num : nums) {
                    queue.offer(curr + num);
                    queue.offer(curr - num);
                    queue.offer(curr ^ num);
                }
            }
            steps++;
        }
        
        return -1;
    }
}