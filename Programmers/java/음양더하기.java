import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
            int target = absolutes[i];
            boolean sign = signs[i];
            
            if(sign) {
                answer += target;
                continue;
            }
            answer += target * -1;
        }
        
        return answer;
    }
}
