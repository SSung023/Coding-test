import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        Map<String, String> wordMap = setMap();
        
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            // 숫자인 경우
            if (Character.isDigit(target)) {
                answer.append(target);
                continue;
            }
            // 문자인 경우 문자열 완성하기
            word.append(target);
            
            // 문자열이 완성된 경우 
            if (wordMap.containsKey(word.toString())) {
                answer.append(wordMap.get(word.toString()));
                word.setLength(0);
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
    
    Map<String, String> setMap() {
        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("one", "1");
        wordMap.put("two", "2");
        wordMap.put("three", "3");
        wordMap.put("four", "4");
        wordMap.put("five", "5");
        wordMap.put("six", "6");
        wordMap.put("seven", "7");
        wordMap.put("eight", "8");
        wordMap.put("nine", "9");
        wordMap.put("zero", "0");
        
        return wordMap;
    }
}
