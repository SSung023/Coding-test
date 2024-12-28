import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = findMaxAcross(stones, k);
        return answer;
    }
    
    private int findMaxAcross(int[] stones, int k) {
        long start = 1;
        long end = 200000000; // 최대로 건널 수 있는 사람의 수
        int answer = 0;
        
        while(start <= end) {
            long mid = start + (end - start) / 2;
            
            // 건널 수 있으므로 사람의 수를 늘려본다
            if(canAcross(stones, mid, k)) {
                answer = Math.max(answer, (int)mid);
                start = mid + 1;
            }
            // 건널 수 없으므로 사람의 수를 줄여본다
            else {
                end = mid - 1;
            }
        }
        return answer;
    }
    
    private boolean canAcross(int[] stones, long num, int k) {
        int pass = 0;
        
        for(int stone : stones) {
            //모든 인원이 건널 수 없으므로 건너뛰는 수 추가
            if(stone - num < 0) {
                pass++;
            }
            //건널 수 있으면 pass를 초기화
            else {
                pass = 0;
            }
            
            // 못 건너는 수가 K가 되는 순간 건너지 못함을 의미
            if(pass == k) {
                return false;
            }
        }
        return true;
    }
}
