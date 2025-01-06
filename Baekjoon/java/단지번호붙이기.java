import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int[][] apartment = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int k = 0; k < line.length(); k++) {
                apartment[i][k] = line.charAt(k) - '0';
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(apartment[i][k] == 1 && !isVisited[i][k]) {
                    isVisited[i][k] = true;
                    int count = dfs(apartment, isVisited, i, k);
                    answer.add(count);
                }
            }
        }
        
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a : answer) {
            System.out.println(a);
        }
    }
    
    public static int dfs(int[][] apartment, boolean[][] isVisited, int curY, int curX) {
        int count = 1;
        int len = apartment.length;
        
        for(int i = 0; i < 4; i++) {
            int nextY = curY + dy[i];
            int nextX = curX + dx[i];
            if(!isValid(nextY, nextX, len, len)) {
                continue;
            }
            if(apartment[nextY][nextX] != 1 || isVisited[nextY][nextX]) {
                continue;
            }
            isVisited[nextY][nextX] = true;
            count += dfs(apartment, isVisited, nextY, nextX);
        }
        
        return count;
    }
    
    private static boolean isValid(int y, int x, int maxY, int maxX) {
        return y >= 0 && x >= 0 && y < maxY && x < maxX;
    }
}
