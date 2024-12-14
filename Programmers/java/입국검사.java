class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000000000000L;
        
        while(start < end) {
            long mid = start + (end - start) / 2;
            
            // mid분 내에 처리가 가능한 경우
            if(isValid(n, times ,mid)) {
                end = mid;
                continue;
            }
            // 처리가 불가능한 경우 시간을 늘려야 함
            start = mid + 1;
        }
        
        return start;
    }
    
    // required 시간 내에 n명 이상 처리할 수 있는지 확인
    public boolean isValid(int n, int[] times, long required) {
        long total = 0;
        for(int time : times) {
            total += required / time;
        }
        return total >= n;
    }
}
