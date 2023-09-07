import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<Node> list = new ArrayList<>();
        
        int ans = 0;
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze, 0));
        }
        
        Collections.sort(list);
        
        list.get(0).rate = 1;
        
        for (int i = 1; i < N; i++) {
            int tmp_gold = list.get(i - 1).gold;
            int tmp_silver = list.get(i - 1).silver;
            int tmp_bronze = list.get(i - 1).bronze;
            Node now = list.get(i);
            
            if (list.get(i).num == K)
                ans = i;
            
            if (now.gold == tmp_gold && now.silver == tmp_silver && now.bronze == tmp_bronze) {
                list.get(i).rate = list.get(i - 1).rate;
            } else {
                list.get(i).rate = i + 1;
            }
        }
        bw.write(list.get(ans).rate + "");
        bw.close();
    }
}

class Node implements Comparable<Node> {
    int num, gold, silver, bronze, rate;
    Node(int num, int gold, int silver, int bronze, int rate) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rate = rate;
    }
    public int compareTo(Node node) {
        if (this.gold == node.gold) {
            if (this.silver == node.silver) {
                return node.bronze - this.bronze;
            } else {
                return node.silver - this.silver;
            }
        } else {
            return node.gold - this.gold;
        }
    }
}