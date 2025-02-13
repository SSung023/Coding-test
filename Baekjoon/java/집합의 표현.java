import java.util.*;
import java.io.*;

class Main {
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(command == 0) {
                union(a, b);
            } else if(command == 1) {
                if(isConnected(a, b))   System.out.println("YES");
                else    System.out.println("NO");
            }
        }
    }
    
    private static int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
    
    private static boolean isConnected(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2)  return true;
        
        return false;
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
}
