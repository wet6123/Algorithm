import java.util.*;

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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        nodes = new TreeNode[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new TreeNode();
            nodes[i].id = i;
        }
        
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            int weight = scanner.nextInt();
            
            nodes[child].weight = weight;
            nodes[parent].children.add(nodes[child]);
        }
        
        findMaxPaths(nodes[1]);
        
        System.out.println(maxSum);
    }
    
    static int findMaxPaths(TreeNode node) {
        if (node == null) return 0;
        
        if (node.children.isEmpty()) {
            return 0;
        }
        
        List<Integer> childPaths = new ArrayList<>();
        
        for (TreeNode child : node.children) {
            findMaxPaths(child);
            
            int pathValue = Math.max(child.maxLeftPath, child.maxRightPath) + child.weight;
            childPaths.add(pathValue);
        }
        
        Collections.sort(childPaths);
        
        int size = childPaths.size();
        if (size >= 2) {
            node.maxLeftPath = childPaths.get(size - 1);
            node.maxRightPath = childPaths.get(size - 2);
        } else if (size == 1) {
            node.maxLeftPath = childPaths.get(0);
            node.maxRightPath = 0;
        }
        
        int sum = node.maxLeftPath + node.maxRightPath;
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = node;
        }
        
        return Math.max(node.maxLeftPath, node.maxRightPath);
    }
    

}