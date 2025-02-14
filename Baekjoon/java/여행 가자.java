import java.util.*;
import java.io.*;

class Main {
    static int[] parents;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parents = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= n; k++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if(isConnected == 0)    continue;
                
                union(i, k);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int city = Integer.parseInt(st.nextToken());
            int parent = find(city);
            set.add(parent);
        }
        
        if(set.size() == 1){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
    
    private static int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);   
        }
        return parents[num];
    }
    
    private static void union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2)  return;
        
        if(root1 < root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
    }
}
