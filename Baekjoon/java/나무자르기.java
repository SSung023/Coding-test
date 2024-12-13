import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int tree[] = new int[n];
        for(int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
        // 이분 탐색을 위한 정렬
        Arrays.sort(tree);
        
        // 최소의 최대값
        long answer = binarySearch(tree, m);
        System.out.println(answer);
    }
    
    public static int binarySearch(int tree[], int m) {
        int start = 0;
        int end = tree[tree.length - 1];
        int res = 0;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            // 원하는 나무의 길이 이상을 얻으면 자르는 높이를 높여본다
            if(cutTree(tree, mid) >= m) {
                res = Math.max(mid, res);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return res;
    }
    
    public static long cutTree(int tree[], int height) {
        long total = 0;
        for(int t : tree) {
            if(t > height) {
                total += t - height;
            }
        }
        return total;
    }
}
