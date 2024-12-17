import java.util.*;

class Solution {
    boolean solution(String s) {
        int numOfP = 0;
        int numOfY = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(target == 'p')   numOfP++;
            else if(target == 'y') numOfY++;
        }

        return numOfP == numOfY;
    }
}
