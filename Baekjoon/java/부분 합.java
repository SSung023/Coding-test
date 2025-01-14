import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = findMinLen(nums, s);
        System.out.println(answer);
    }
    
    private static int findMinLen(int[] nums, int s) {
        int answer = 100001; //최대 길이가 100000이므로
        int start = 0;
        int end = 0;
        int sum = 0;
    
        while(start <= end && end <= nums.length) {
            if(sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= nums[start++];
            }
            else if(end == nums.length) {
                break;
            }
            else {
                sum += nums[end++];
            }
        }
    
        return answer == 100001 ? 0 : answer;
    }
}
