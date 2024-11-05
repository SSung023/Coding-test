import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        int before = arr[0];
        answer.add(before);
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] != before) {
                answer.add(arr[i]);
                before = arr[i];
            }
            else {
                before = arr[i];
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
