import java.io.*;
import java.util.*;

class Main {
    static int[] parents;
    static Edge[] edges;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        edges = new Edge[e];
        parents = new int[v + 1];
        for(int i = 0; i <= v; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(src, dest, cost);
        }
        
        Arrays.sort(edges);
        int selected = 0;
        int totalCost = 0;
        for(Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;
            int cost = edge.cost;
            
            if(union(src, dest)) {
                totalCost += cost;
                selected++;
            }
            if(selected == v - 1)   break;
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
        if(root1 == root2)  return false;
        
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
