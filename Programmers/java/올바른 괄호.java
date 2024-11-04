import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        // ( 일 때에 push, ) 일 때 pop, exception 발생 시 false 반환
        for(int i = 0; i < s.length(); i++) {
            Character target = s.charAt(i);
            if (target == '(') {
                st.push(target);
                continue;
            }
            try {
                st.pop();
            } catch (Exception e) {
                return false;
            }
        }

        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
