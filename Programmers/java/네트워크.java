import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n];
        boolean[] isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int k = 0; k < computers[0].length; k++) {
                if(i == k)  continue;
                if(computers[i][k] == 0)    continue;
                graph[i].add(k);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(graph, isVisited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(List<Integer>[] graph, boolean[] isVisited, int cur) {
        isVisited[cur] = true;
        
        List<Integer> nextNodes = graph[cur];
        for(int next : nextNodes) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            dfs(graph, isVisited, next);
        }
    }
    
    private void bfs(List<Integer>[] graph, boolean[] isVisited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            List<Integer> nextNodes = graph[cur];
            for(int next : nextNodes) {
                if(isVisited[next]) continue;
                isVisited[next] = true;
                queue.add(next);
            }
        }
    }
}
