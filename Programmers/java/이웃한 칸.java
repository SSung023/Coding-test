import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int hMax = board.length;
        int wMax = board[0].length;
        
        int dh[] = {0, 1, -1, 0};
        int dw[] = {1, 0, 0, -1};
        
        String target = board[h][w];
        for(int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            if(hCheck < 0 || hCheck >= hMax || wCheck < 0 || wCheck >= wMax) {
                continue;
            }
            
            String compare = board[hCheck][wCheck];
            
            if(target.equals(compare)) answer++;
        }
        
        
        return answer;
    }
}
