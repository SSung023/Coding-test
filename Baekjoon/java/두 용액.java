import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long liquid[] = new long[n];
        for(int i = 0; i < n; i++) {
            liquid[i] = sc.nextLong();
        }
        Arrays.sort(liquid);
        
        long answer[] = find(liquid);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    
    public static long[] find(long[] liquid) {
        long answer[] = new long[2];
        long candidate = 1000000000000L;
        int left = 0;
        int right = liquid.length - 1;
        
        while(left < right) {
            long mixed = liquid[left] + liquid[right];
            long target = Math.abs(mixed);
            // System.out.println(target);
            // 만일 이전에 섞은 값보다 절댓값이 더 작다면 정답 갱신
            if(target < candidate) {
                answer[0] = liquid[left];
                answer[1] = liquid[right];
                candidate = target;
            }
            
            // 음수인 경우, left ++
            if(mixed < 0) {
                left++;
            }
            // 양수인 경우, right--;
            else {
                right--;
            }
        }
        return answer;
    }
}
