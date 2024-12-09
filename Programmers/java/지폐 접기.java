import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(!isFit(wallet, bill)) {
            if(bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            }
            else {
                bill[1] = bill[1] / 2;
            }
            
            answer++;
        }
        
        return answer;
    }
    
    public boolean isFit(int[] wallet, int[] bill) {
        // 그대로 들어가는지 확인
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
            return true;
        }
        // 90도 돌려서 되는건지 확인
        if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
            return true;
        }
        
        return false;
    }
}
