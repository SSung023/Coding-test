import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> edges = initEdge(n, edge);
        int[] distance = getDistance(edges, 0, new boolean[n]);
        
        int maxDistance = 0;
        for(int d : distance) {
            maxDistance = Math.max(maxDistance, d);
        }
        
        // 최대 거리를 가진 노드 개수 세기
        for(int d : distance) {
            if(d == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private List<List<Integer>> initEdge(int n, int[][] edge) {
        List<List<Integer>> edges = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for(int[] info : edge) {
            int start = info[0] - 1;
            int end = info[1] - 1;
            edges.get(start).add(end);
            edges.get(end).add(start);
        }
        
        return edges;
    }
    
    private int[] getDistance(List<List<Integer>> edges, int start, boolean[] isVisited) {
        int[] distance = new int[isVisited.length];
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        distance[0] = 0;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> nextNodes = edges.get(cur);
            for(int next : nextNodes) {
                if(isVisited[next]) {
                    continue;
                }
                isVisited[next] = true;
                queue.add(next);
                distance[next] = distance[cur] + 1;
            }
        }
        return distance;
    }
}
