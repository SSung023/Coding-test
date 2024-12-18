import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder targetBuilder = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append(convert(targetBuilder.toString()));
                targetBuilder.setLength(0);
                sb.append(' ');
                continue;
            }
            targetBuilder.append(c);
        }
        
        // 마지막 단어 처리 추가
        if(targetBuilder.length() > 0) {
            sb.append(convert(targetBuilder.toString()));
        }
        
        return sb.toString();
    }
    
    public String convert(String target) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
