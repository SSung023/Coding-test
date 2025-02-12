import java.io.*;
import java.util.*;

class Main {
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Star[] stars = new Star[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(i, x, y);
        }
        
        // calculate edges
        for(int i = 0; i < n; i++) {
            for(int k = i + 1; k < n; k++) {
                Star src = stars[i];
                Star dest = stars[k];
                double cost = calculateDist(src, dest);
                edges.add(new Edge(src.num, dest.num, cost));
            }
        }
        Collections.sort(edges);
        
        int selected = 0;
        double totalCost = 0.0;
        for(Edge edge : edges) {
            if(union(edge.src, edge.dest)) {
                selected++;
                totalCost += edge.cost;
            }
            if(selected == n - 1)   break;
        }
        
        System.out.printf("%.2f", totalCost);
    }
    
    private static int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
    
    private static boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2)  return false;
        
        if(root1 < root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
        return true;
    }
    
    private static double calculateDist(Star src, Star dest) {
        double distX = Math.abs(src.x - dest.x);
        double distY = Math.abs(src.y - dest.y);
        
        double dist = Math.pow(Math.pow(distX, 2) + Math.pow(distY, 2), 0.5);
        return dist;
    }
}

class Star {
    int num;
    double x;
    double y;
    
    public Star(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    double cost;
    
    public Edge(int src, int dest, double cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge other) {
        if(this.cost > other.cost) {
            return 1;
        } else if(this.cost < other.cost) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public String toString() {
        return String.format("src:%d, dest:%d, cost: %f\n", src, dest, cost);
    }
}
