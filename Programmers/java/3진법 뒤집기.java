import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String convert = Integer.toString(n, 3);
        convert = new StringBuilder(convert).reverse().toString();
        answer = Integer.parseInt(convert, 3);
        
        return answer;
    }
}
