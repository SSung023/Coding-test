import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            char target = my_string.charAt(i);
            if(set.contains(target)) {
                continue;
            }
            set.add(target);
            sb.append(target);
        }
        return sb.toString();
    }
}
