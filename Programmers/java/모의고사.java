import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int max = 0;
        int correct[] = new int[3];
        int rules[][] = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int idx = 0; idx < answers.length; idx++) {
            int answer = answers[idx];
            // System.out.printf("%d번째 답안: %d\n", idx, answer);
            
            for(int person = 0; person < 3; person++) {
                int rule[] = rules[person];
                int picked = getPicked(rule, idx);
                // System.out.printf("%d번째 수포자가 선택한 답안: %d\n", person, picked);
                
                if(answer == picked) {
                    correct[person]++;
                    max = Math.max(correct[person], max);
                }
            }
        }
        
        // System.out.println(Arrays.toString(correct));
        
        final int maxCorrect = max;
        return IntStream.range(0, 3)
            .filter(i -> correct[i] == maxCorrect)
            .map(i -> i + 1)
            .toArray();
    }
    
    public int getPicked(int rule[], int idx) {
        int pattern = idx % rule.length;
        int picked = rule[pattern];
        return picked;
    }
}
