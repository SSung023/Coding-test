import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(List.of(gems)); // 전체 보석 종류
        Map<String, Integer> includes = new HashMap<>(); // 현재 구간에서의 보석 보유 현황
        
        int front = 0;
        int back = gems.length;
        
        int start = 0;
        int end = 0;
        includes.put(gems[start], 1);
        
        while(start < gems.length && start <= end) {
            // System.out.printf("start: %d, end: %d\n", start + 1, end+1);
            
            //모든 종류의 보석이 한 개 이상 있는 경우
            if(includes.keySet().size() == gemSet.size()) {
                if(end - start < back - front) {
                    front = start;
                    back = end;
                }
                
                String frontGem = gems[start];
                includes.put(frontGem, includes.get(frontGem) - 1);
                if(includes.get(frontGem) == 0) {
                    includes.remove(frontGem);
                }
                // System.out.printf("모든 보석이 있으므로 start + 1\n");
                // System.out.println(includes.entrySet());
                start++;
            }
            //모든 종류의 보석이 있지 않은 경우
            else {
                end++;
                if(end >= gems.length)  break;
                
                String endGem = gems[end];
                includes.put(endGem, includes.getOrDefault(endGem, 0) + 1);
            }
        }
        
        return new int[] {front + 1, back + 1};
    }
}
