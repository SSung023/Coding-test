import java.util.stream.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        List<Stage> curStages = new ArrayList<>();
        int[] failed = new int[N + 2];
        int remain = stages.length;
        Arrays.sort(stages);
        
        // 각 스테이지 별로 실패한 인원 계산
        for(int stage: stages) {
            failed[stage]++;
        }
        
        // 실패율 계산
        for(int i = 1; i <= N; i++) {
            int failedNum = failed[i];
            double failRate = (double)failedNum / remain;
            curStages.add(new Stage(i, failRate));
            
            remain -= failedNum;
        }
        Collections.sort(curStages, Collections.reverseOrder());
        
        List<Integer> answer = curStages.stream()
                                        .map(stage -> stage.id)
                                        .collect(Collectors.toList());
        
        return answer;
    }
    
    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;
        
        public Stage(int id, double failure) {
            this.id = id;
            this.failure = failure;
        }
        
        @Override
        public int compareTo(Stage s) {
            if (failure < s.failure ) {
                return -1;
            }
            if (failure > s.failure ) {
                return 1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return String.valueOf(id) + ", " + String.valueOf(failure);
        }
    }
}
