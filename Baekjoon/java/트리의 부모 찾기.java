import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Integer>[] tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }
        int[] parents = findParent(tree, 1, n);
        
        for(int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
    
    public static int[] findParent(List<Integer>[] tree, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int[] parents = new int[n + 1];
        
        isVisited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nextNodes = tree[cur];
            for(int next : nextNodes) {
                if(isVisited[next]) continue;
                isVisited[next] = true;
                queue.add(next);
                parents[next] = cur;
            }
        }
        return parents;
    }
}
