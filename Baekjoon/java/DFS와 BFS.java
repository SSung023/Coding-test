import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        isVisited = new boolean[n + 1];
        List<Integer>[] edges = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }
        
        for(int i = 0; i <= n; i++) {
            Collections.sort(edges[i]);
        }
        
        isVisited[v] = true;
        dfs(edges, v);
        
        Arrays.fill(isVisited, false);
        System.out.printf("\n");
        
        bfs(edges, v);
    }
    
    public static void bfs(List<Integer>[] edges, int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        isVisited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.printf("%d ", cur);
            
            List<Integer> nextNodes = edges[cur];
            for(int next : nextNodes) {
                if(isVisited[next]) continue;
                isVisited[next] = true;
                queue.add(next);
            }
        }
    }
    
    public static void dfs(List<Integer>[] edges, int cur) {
        System.out.printf("%d ", cur);
        
        List<Integer> nextNodes = edges[cur];
        for(int next : nextNodes) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            dfs(edges, next);
        }
    }
}
