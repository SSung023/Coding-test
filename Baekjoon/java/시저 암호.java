import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char converted = convert(s.charAt(i), n);
            answer += String.valueOf(converted);
        }
        
        return answer;
    }
    
    private char convert(Character target, int n) {
        if(Character.isUpperCase(target)) {
            return (char)('A' + (target - 'A' + n) % 26);
        }
    
        if(Character.isLowerCase(target)) {
            return (char)('a' + (target - 'a' + n) % 26);
        }
    
        return target;
    }
}
