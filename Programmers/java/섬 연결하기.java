import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Edge[] edges = Arrays.stream(costs)
            .map(edge -> new Edge(edge[0], edge[1], edge[2]))
            .sorted(Comparator.comparingInt(e -> e.cost))
            .toArray(Edge[]::new);
        
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        
        int totalCost = 0;
        for(Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];
            
            if(node1.isConnected(node2))    continue;
            node1.merge(node2);
            totalCost += edge.cost;
            
        }
        
        return totalCost;
    }
}

class Edge {
    public int u;
    public int v;
    public int cost;
    
    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}

class Node {
    private int depth = 1;
    private Node parent = null;
    
    public boolean isConnected(Node o) {
        return root() == o.root();
    }
    
    private Node root() {
        if(parent == null)  return this;
        return parent.root();
    }
    
    public void merge(Node o) {
        if(isConnected(o))  return;
        
        Node myRoot = root();
        Node otherRoot = o.root();
        
        if(myRoot.depth > otherRoot.depth) {
            otherRoot.parent = myRoot;
        } else if(myRoot.depth < otherRoot.depth) {
            myRoot.parent = otherRoot;
        } else {
            otherRoot.parent = myRoot;
            myRoot.depth += 1;
        }
    }
}
