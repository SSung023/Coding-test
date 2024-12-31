import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = initQueue(bridge_length);
        
        int curWeight = truck_weights[0];
        queue.add(curWeight);
        int sec = 1;
        int idx = 1;
        
        while(idx < truck_weights.length) {
            // System.out.println(queue);
            int quit = queue.poll();
            curWeight -= quit;
            int next = truck_weights[idx];
            
            // 다음 트럭이 올라갈 수 있는 상황이라면
            if(curWeight + next <= weight) {
                queue.add(next);
                curWeight += next;
                idx++;
            }
            else {
                queue.add(0);
            }
            sec++;
        }
        
        while(!queue.isEmpty()) {
            // System.out.println(queue);
            queue.poll();
            sec++;
        }
        
        return sec;
    }
    
    private Queue<Integer> initQueue(int bridge_length) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length - 1; i++) {
            queue.add(0);
        }
        return queue;
    }
}
