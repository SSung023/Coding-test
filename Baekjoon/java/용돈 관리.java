import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] need = new int[n];
        for(int i = 0; i < n; i++) {
            need[i] = sc.nextInt();
        }
        
        int answer = getMinUnit(need, m);
        System.out.println(answer);
    }
    
    private static int getMinUnit(int[] need, int m) {
        int start = Arrays.stream(need).max().getAsInt();
        int end = Arrays.stream(need).sum();
        int answer = end;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int withdrawals = getWithdrawCnt(need, mid);
            
            if (withdrawals <= m) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static int getWithdrawCnt(int[] need, int unit) {
        int cnt = 1;  // 최소 1번은 인출해야 함
        int current = unit;
        
        for(int i = 0; i < need.length; i++) {
            if(current < need[i]) {
                cnt++;
                current = unit;
            }
            current -= need[i];
        }
        
        return cnt;
    }
}
