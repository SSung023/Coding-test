import java.util.*;

class Solution {
    public boolean solution(String s) {
        String regex = "[0-9]{4}|[0-9]{6}";
        
        return s.matches(regex);
    }
}
