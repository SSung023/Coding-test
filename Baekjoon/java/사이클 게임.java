import java.io.*;
import java.util.*;

class Main {
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for(int i = 1; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            boolean isCycled = union(n1, n2);
            if(!isCycled) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(0);
    }
    
    private static int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
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
