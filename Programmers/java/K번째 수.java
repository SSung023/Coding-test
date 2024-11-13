import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> arrays = new ArrayList<>();
        for(int num : array) {
            arrays.add(num);
        }
        
        for(int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int target = command[2] - 1;
            
            List<Integer> subList = new ArrayList<>(arrays.subList(start, end));
            subList.sort(Integer::compareTo);
            answer.add(subList.get(target));
        }
        return answer;
    }
}
