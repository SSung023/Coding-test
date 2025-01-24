import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int answer = countGoodNum(nums);
        System.out.println(answer);
        
        br.close();
    }
    
    private static int countGoodNum(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            int target = nums[i];
            int start = 0;
            int end = n - 1;
            
            // 투포인터 조건
            while(start < end) {
                int sum = nums[start] + nums[end];
                if(sum == target) {
                    if(start != i && end != i) {
                        answer++;
                        break;
                    } else if(start == i) {
                        start++;
                    } else if(end == i) {
                        end--;
                    }
                }
                else if(sum < target) {
                    start++;
                }
                else if(sum > target) {
                    end--;
                }
            }
        }
        
        return answer;
    }
}
