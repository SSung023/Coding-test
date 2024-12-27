import java.util.*;

class Solution {
    public int solution(String before, String after) {
        if(before.length() != after.length()) {
            return 0;
        }
        
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
    
    private Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            map.putIfAbsent(target, 0);
            map.put(target, map.get(target) + 1);
        }
        return map;
    }
}
