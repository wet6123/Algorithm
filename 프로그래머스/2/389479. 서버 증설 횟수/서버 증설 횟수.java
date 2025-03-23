class Solution {
    public int solution(int[] players, int m, int k) {
        int[] operatingServers = new int[24];
        int totalDeployments = 0;
        
        for (int hour = 0; hour < 24; hour++) {
            int requiredServers = players[hour] / m;
            
            if (operatingServers[hour] < requiredServers) {
                int additionalServers = requiredServers - operatingServers[hour];
                totalDeployments += additionalServers;
                
                for (int i = 0; i < k; i++) {
                    if (hour + i < 24) {
                        operatingServers[hour + i] += additionalServers;
                    }
                }
            }
        }
        
        return totalDeployments;
    }
}