import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt(); // 가지고 있는 개수
        int n = sc.nextInt(); // 필요한 개수
        
        int cables[] = new int[k];
        for(int i = 0; i < k; i++ ){
            cables[i] = sc.nextInt();
        }
        
        Arrays.sort(cables);
        
        long answer = binarySearch(cables, n);
        System.out.println(answer);
    }
    
    public static long binarySearch(int cables[], int target) {
        long res = 0;
        long start = 1;
        long end = cables[cables.length - 1];
        
        while(start <= end) {
            long mid = start + (end - start) / 2;
            // 충분하다면 길이를 늘려봐도 됨
            if(cutCables(cables, mid) >= target) {
                res = mid;
                start = mid + 1;
                continue;
            }
            // 개수가 부족하다면 길이를 줄여야 함
            end = mid - 1;
        }
        return res;
    }
    
    public static int cutCables(int cables[], long len) {
    return Arrays.stream(cables)
                .map(cable -> cable / (int) len)
                .sum();
    }
}
