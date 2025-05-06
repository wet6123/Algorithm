import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }
        
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewels);
        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long totalValue = 0;
        int jewelIdx = 0;
        
        for (int i = 0; i < K; i++) {
            while (jewelIdx < N && jewels[jewelIdx].weight <= bags[i]) {
                pq.offer(jewels[jewelIdx].value);
                jewelIdx++;
            }
            
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }
        
        bw.write(totalValue + "");
        bw.close();
    }
    
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;
        
        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
        @Override
        public int compareTo(Jewel other) {
            return this.weight - other.weight;
        }
    }
}