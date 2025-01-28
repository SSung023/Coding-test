import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        List<Integer> graph[];
        int[] in; // 들어오는 정점의 개수
        boolean[] isVisited;
        
        //1. 정점의 개수 찾기
        int numOfNode = 0;
        for(int[] edge : edges) {
            numOfNode = Math.max(numOfNode, Math.max(edge[0], edge[1]));
        }
        
        //2. 그래프 초기화
        isVisited = new boolean[numOfNode + 1];
        in = new int[numOfNode + 1];
        graph = new ArrayList[numOfNode + 1];
        for(int i = 0; i <= numOfNode; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            in[end]++;
        }
        
        //3. 생성한 정점 번호 찾기
        int newNode = findNewNode(graph, in, numOfNode);
        List<Integer> starts = graph[newNode]; // 탐색을 시작할 정점 리스트
        
        //4. 생성한 정점에서 나가는 간선들 끊기
        for(int start : starts) {
            in[start]--;
        }
        graph[newNode] = new ArrayList<>();
        
        // 각 그래프 유형 개수 카운트
        int stick = 0;
        int donut = 0;
        int eight = 0;
        for(int start : starts) {
            // System.out.printf("시작 정점:%d\n", start);
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                if(in[cur] == 2 && graph[cur].size() == 2) {
                    eight++;
                    break;
                }
                
                List<Integer> nextNodes = graph[cur];
                if(nextNodes.size() == 0) {
                    stick++;
                    break;
                }
                for(int next : nextNodes) {
                    if(next == start) {
                        donut++;
                        break;
                    }
                    if(isVisited[next]) continue;
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
            
        }
        
        return new int[] {newNode, donut, stick, eight};
    }
    
    private int findNewNode(List<Integer> graph[], int[] in, int numOfNode) {
        // 생성된 정점 번호는 모두 나가는 간선만 있으면서 && 간선의 개수가 2개 이상
        for(int i = 1; i <= numOfNode; i++) {
            int out = graph[i].size();
            if(out >= 2 && in[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
