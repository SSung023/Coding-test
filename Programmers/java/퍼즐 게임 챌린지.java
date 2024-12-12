import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 100000;
        int min = 1;
        int max = 100000; // 최대 난이도
        
        while(min <= max) {
            int mid = (min + max) / 2;
            long solveTime = getSolveTime(diffs, times, mid);
            
            // 시간 내에 풀 수 있으므로 숙련도를 더 내려도 됨
            if(solveTime <= limit) {
                max = mid - 1;
                level = Math.min(level, mid);
                continue;
            }
            // 시간 내에 풀 수 없으면 숙련도를 높여봐야 함
            min = mid + 1;
        }
        
        return level;
    }
    
    public long getSolveTime(int[] diffs, int[] times, int level) {
        long total = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level) total += times[i];
            else total += (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
        }
        return total;
    }
}
