import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char target : s.toCharArray()){
            // stack에 요소가 있고, 제일 위에 있는 요소가 target과 일치하면 pop
            if(!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                continue;
            }
            // 그렇지 않으면 같지 않다는 것이므로 push
            stack.push(target);
        }
        
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
