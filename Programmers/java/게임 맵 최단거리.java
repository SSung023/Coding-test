import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int[] dy = {0, -1, 0, 1}; // left, up, right, down
        int[] dx = {-1, 0, 1, 0};
        int maxHeight = maps.length;
        int maxWidth = maps[0].length;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        boolean[][] isVisited = new boolean[maxHeight][maxWidth];
        Queue<Pos> queue = new LinkedList<>();
        
        queue.add(new Pos(0, 0, 1));
        isVisited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            
            if(cur.y == maxHeight - 1 && cur.x == maxWidth - 1) {
                return cur.dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nextY = cur.y + dy[i];
                int nextX = cur.x + dx[i];
                
                if(isValidPos(maxHeight, maxWidth, nextY, nextX)) {
                    // 유효한 좌표일 때에만
                    if(!isVisited[nextY][nextX] && maps[nextY][nextX] == 1) {
                        isVisited[nextY][nextX] = true;
                        queue.add(new Pos(nextY, nextX, cur.dist + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean isValidPos(int maxHeight, int maxWidth, int curY, int curX) {
        if (curY >= maxHeight || curX >= maxWidth) {
            return false;
        }
        if(curY < 0 || curX < 0){
            return false;
        }
        return true;
    }
    
    class Pos{
        int y;
        int x;
        int dist;
        
        public Pos(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
