import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> wins = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> loses = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < n; i++) {
            wins.add(new ArrayList<>());
            loses.add(new ArrayList<>());
        }
        
        for(int i = 0; i < results.length; i++) {
            int winPlayer = results[i][0] - 1;
            int losePlayer = results[i][1] - 1;
            
            wins.get(winPlayer).add(losePlayer);
            loses.get(losePlayer).add(winPlayer);
        }
        
        for(int i = 0; i < n; i++) {
            int win = countWin(wins, i, new boolean[n]);
            int lose = countLose(loses, i, new boolean[n]);
            
            // System.out.printf("%d번 선수 - win: %d, lose: %d\n", i, win, lose);
            if(win + lose + 1 == n) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int countWin(ArrayList<ArrayList<Integer>> wins, int cur, boolean[] isVisited) {
        int count = 0;
        
        List<Integer> nextNodes = wins.get(cur);
        
        for(int next : nextNodes) {
            if(isVisited[next]) {
                continue;
            }
            // System.out.println(next);
            isVisited[next] = true;
            count += countWin(wins, next, isVisited) + 1;
        }
        
        return count;
    }
    
    private int countLose(ArrayList<ArrayList<Integer>> loses, int cur, boolean[] isVisited) {
        int count = 0;
        
        List<Integer> nextNodes = loses.get(cur);
        
        for(int next : nextNodes) {
            if(isVisited[next]) {
                continue;
            }
            // System.out.println(next);
            isVisited[next] = true;
            count += countLose(loses, next, isVisited) + 1;
        }
        
        return count;
    }
}
