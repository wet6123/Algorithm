import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<Node> list = new ArrayList<>();
        
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int rank = 1;
            list.add(new Node(weight, height, rank));
        }
        
        for(int i = 0; i < N; i++) {
            Node now = list.get(i);
            for(int j = i + 1; j < N; j++) {
                Node next = list.get(j);
                if(now.weight > next.weight && now.height > next.height) {
                    list.get(j).rank++;
                } else if(now.weight < next.weight && now.height < next.height) {
                    list.get(i).rank++;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            bw.write(list.get(i).rank + " ");
        }
        bw.close();
    }
}

class Node {
    int weight, height, rank;
    Node(int weight, int height, int rank) {
        this.weight = weight;
        this.height = height;
        this.rank = rank;
    }
}