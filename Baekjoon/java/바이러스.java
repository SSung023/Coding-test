import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        isVisited = new boolean[n + 1];
        List<Integer>[] edges = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }
        
        isVisited[1] = true;
        int infected = spread(edges, 1) - 1;
        System.out.println(infected);
    }
    
    private static int spread(List<Integer>[] edges, int cur) {
        int cnt = 1;
        
        List<Integer> nextNodes = edges[cur];
        for(int next : nextNodes) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            cnt += spread(edges, next);
        }
        return cnt;
    }
}
