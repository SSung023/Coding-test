import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // 큐에 인덱스와 우선순위를 함께 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int max = findMax(queue); // 큐에서 가장 큰 우선순위 확인
            
            // 현재보다 우선순위가 높다면 다시 큐에 추가
            if (cur[1] < max) {
                queue.add(cur);
            } else {
                answer++;
                
                // 찾던 프로세스라면 정답 반환
                if (cur[0] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
    
    // 큐에서 최댓값을 찾는 함수
    public int findMax(Queue<int[]> queue) {
        int max = Integer.MIN_VALUE;
        
        for (int[] value : queue) {
            if (value[1] > max) {
                max = value[1];
            }
        }
        
        return max;
    }
}
