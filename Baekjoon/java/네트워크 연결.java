import java.io.*;
import java.util.*;

class Main {
    static int[] parents;
    static Edge[] edges;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        edges = new Edge[m];
        parents = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(src, dest, cost);
        }
        
        Arrays.sort(edges);
        
        int selected = 0;
        int totalCost = 0;
        for(Edge edge : edges) {
            if(union(edge.src, edge.dest)) {
                selected++;
                totalCost += edge.cost;
            }
            if(selected == n - 1)    break;
        }
        
        System.out.println(totalCost);
    }
    
    private static int find(int node) {
        if(parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }
  
    private static boolean union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        if(root1 == root2)    return false;
        
        if(root1 < root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
        return true;
    }

}

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int cost;
    
    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}
