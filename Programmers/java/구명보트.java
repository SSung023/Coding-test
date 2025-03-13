import java.util.*;

//제한 -> 최대 무게 제한 limit, 하나의 보트에 2명씩
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        while(left < right) {
            int weight = people[left] + people[right];
            if(weight > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            answer++;
        }
        
        if(left == right) {
            answer++;
        }
        
        return answer;
    }
}
