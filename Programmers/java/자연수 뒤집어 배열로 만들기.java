import java.util.*;

class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        
        for(int i = str.length() - 1; i >= 0; i--) {
            char target = str.charAt(i);
            answer[str.length() - 1 - i] = target - '0';
        }
        
        return answer;
    }
}
