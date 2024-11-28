import java.util.*;

class Solution {
    public List<Integer> solution(int n, String[] words) {
        Set<String> dict = new HashSet<>();
    
        String before = words[0];
        dict.add(before);
        
        for(int i = 1; i < words.length; i++) {
            String word = words[i];
            Character first = word.charAt(0);
            Character last = before.charAt(before.length() - 1);
            
            // 탈락 조건일 때
            if (first != last || dict.contains(word)) {
                int num = i % n + 1;
                int turn = i / n + 1;
                
                return List.of(num, turn);
            }
            
            // 조건이 유효할 때
            dict.add(word);
            before = word;
        }
        
        return List.of(0, 0);
    }
}
