import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        for(int h = citations.length; h >= 1; h--) {
            //뒤에서 i번째인 값이 h 이상이면 
            int idx = citations.length - h;
            if(citations[idx] >= h) {
                return h;
            }
        }
        return 0;
    }
}
