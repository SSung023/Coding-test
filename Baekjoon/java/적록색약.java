import java.util.*;
import java.io.*;

class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] isVisited = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int k = 0; k < n; k++) {
                map[i][k] = line.charAt(k);
            }
        }
        
        int normalCnt = 0;
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(!isVisited[i][k]) {
                    isVisited[i][k] = true;
                    dfs(map, isVisited, i, k, true);
                    normalCnt++;
                }
            }
        }
        
        int abnormalCnt = 0;
        isVisited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(!isVisited[i][k]) {
                    isVisited[i][k] = true;
                    dfs(map, isVisited, i, k, false);
                    abnormalCnt++;
                }
            }
        }
        
        System.out.printf("%d %d", normalCnt, abnormalCnt);
    }
    
    public static void dfs(char[][] map, boolean[][] isVisited, int y, int x, boolean isNormal) {
        isVisited[y][x] = true;
        char cur = map[y][x];
        int len = map.length;
        
        for(int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(!isInside(nextY, nextX, len) || isVisited[nextY][nextX]) {
                continue;
            }
            if(isSameSection(cur, map[nextY][nextX], isNormal)) {
                dfs(map, isVisited, nextY, nextX, isNormal);
            }
        }
    }
    
    public static boolean isSameSection(char cur, char compare, boolean isNormal) {
        if(isNormal) {
            return cur == compare;
        }
        switch(cur) {
            case 'R':
                return compare == 'R' || compare == 'G';
            case 'B':
                return compare == 'B';
            case 'G':
                return compare == 'R' || compare == 'G';
        }
        return false;
    }
    
    public static boolean isInside(int y, int x, int len) {
        return y >= 0 && y < len && x >= 0 && x < len;
    }
}
