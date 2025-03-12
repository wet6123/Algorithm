import java.util.*;
import java.io.*;

class TreeNode {
    int id;                
    int weight;             
    List<TreeNode> children = new ArrayList<>();
    int maxLeftPath = 0;    
    int maxRightPath = 0;   
}

public class Main {
    static TreeNode[] nodes;
    static TreeNode maxNode = null;
    static int maxSum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        nodes = new TreeNode[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new TreeNode();
            nodes[i].id = i;
        }
        
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            nodes[child].weight = weight;
            nodes[parent].children.add(nodes[child]);
        }
        
        findMaxPaths(nodes[1]);
        
        bw.write(String.valueOf(maxSum));
        bw.newLine();
        
        br.close();
        bw.close();
    }
    
    static int findMaxPaths(TreeNode node) {
        if (node == null) return 0;
        
        if (node.children.isEmpty()) {
            return 0;
        }
        
        int max1 = 0;
        int max2 = 0;
        
        for (TreeNode child : node.children) {
            findMaxPaths(child);
            
            int pathValue = Math.max(child.maxLeftPath, child.maxRightPath) + child.weight;
            
            if (pathValue > max1) {
                max2 = max1;
                max1 = pathValue;
            } else if (pathValue > max2) {
                max2 = pathValue;
            }
        }
        
        node.maxLeftPath = max1;
        node.maxRightPath = max2;
        
        int sum = max1 + max2;
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = node;
        }
        
        return Math.max(node.maxLeftPath, node.maxRightPath);
    }
}