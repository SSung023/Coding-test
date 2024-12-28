import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] houses = new int[n];
        for(int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }
        
        Arrays.sort(houses);
        long answer = findMaxDist(houses, c);
        
        System.out.println(answer);
    }
    
    private static long findMaxDist(int[] houses, int c) {
        long answer = 0;
        long start = 1;
        long end = houses[houses.length - 1];
        
        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(getNumOfInstall(houses, mid) >= c) {
                //공유기를 c개 이상 설치했으므로
                //거리를 늘려본다
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
            else {
                //공유기를 c개 미만 설치했으므로
                //거리를 줄여본다
                end = mid - 1;
            }
        }
        return answer;
    }
    
    private static int getNumOfInstall(int[] houses, long dist) {
        int install = 1;
        int prevIdx = 0;
        
        for(int i = 1; i < houses.length; i++) {
            int curDist = houses[i] - houses[prevIdx];
            // 거리가 dist 이상이라면 공유기 설치
            if (curDist >= dist) {
                install++;
                //거리 재설정
                prevIdx = i;
            }
        }
        return install;
    }
}
