import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int maxLength = numbers.length - 1;
        
        Queue<Status> queue = new LinkedList<>();
        queue.add(new Status(-numbers[0], 0));
        queue.add(new Status(numbers[0], 0));
        
        while(!queue.isEmpty()) {
            Status status = queue.poll();
            int curValue = status.value;
            int curPos = status.pos;
            
            // 제일 마지막까지 왔으므로 검사 대상
            if(curPos == maxLength) {
                if(curValue == target) {
                    answer++;
                }
                continue;
            }
            
            int next = numbers[curPos + 1];
            queue.add(new Status(-next + curValue, curPos + 1));
            queue.add(new Status(next + curValue, curPos + 1));
        }
        
        
        return answer;
    }
    
    class Status {
        int value;
        int pos;
        
        public Status(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
}
