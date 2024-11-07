import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            String target = phone_book[i];
            String compare = phone_book[i+1];
            if(compare.startsWith(target)) {
                return false;
            }
        }
        
        return answer;
    }
}
