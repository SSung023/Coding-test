import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville) {
            pq.add(num);
        }
        
        // 음식이 2개 이상 있을 때
        while(pq.size() >= 2) {
            if(pq.peek() >= K) {
                return answer;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + (second * 2));
            answer++;
        }
        
        if(pq.peek() >= K) {
            return answer;
        }
        return -1;
    }
}
