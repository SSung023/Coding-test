import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] budget = new int[n];
        for(int i = 0; i < n; i++) {
            budget[i] = sc.nextInt();
        }
        int total = sc.nextInt();
        
        Arrays.sort(budget);
        int upper = findMaxBudget(budget, total);
        int answer = findAnswer(budget, upper);
        System.out.println(answer);
    }
    
    private static int findMaxBudget(int[] budget, int total) {
        int answer = 0;
        int start = 1;
        int end = 100000;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            //유효하기 때문에 예산을 늘려봄
            if(isValid(budget, total, mid)) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }
    
    private static boolean isValid(int[] budget, int total, int upper) {
        int sum = Arrays.stream(budget)
                .map(b -> Math.min(b, upper))
                .sum();
        return sum <= total;
    }
    
    private static int findAnswer(int[] budget, int upper) {
        int max = 0;
        for(int b : budget) {
            int tmp = Math.min(b, upper);
            max = Math.max(tmp, max);
        }
        return max;
    }
}
