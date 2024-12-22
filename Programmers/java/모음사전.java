import java.util.*;

class Solution {
    char[] chars = "AEIOU".toCharArray();
    
    public int solution(String word) {
        List<String> words = addWord("");
        return words.indexOf(word);
    }
    
    public List<String> addWord(String cur) {
        List<String> words = new ArrayList<>();
        words.add(cur);
        
        // 종료 조건
        if(cur.length() == 5) {
            return words;
        }
        
        for(char c : chars) {
            words.addAll(addWord(cur + c));
        }
        return words;
    }
}
