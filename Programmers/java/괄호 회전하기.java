import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            sb.setLength(0);
            String first = s.substring(i, len);
            String second = s.substring(0, i);
            sb.append(first);
            sb.append(second);
            if (isValid(sb.toString())) {
                answer++;
            }
            
        }
        return answer;
    }
    
    private boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(target == '[' || target == '{' || target == '(') {
                st.add(target);
                continue;
            }
            
            if(st.isEmpty()) {
                return false;
            }
            // ], }, ) 일 때
            //짝이 맞을 때에만 뽑을 수 있음
            char pair = findPair(target);
            if(pair == st.peek()) {
                st.pop();
            }
            else {
                return false;
            }
        }
        
        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
    
    private char findPair(char target) {
        switch(target) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
        }
        return ' ';
    }
}
