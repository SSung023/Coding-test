import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        String pattern[] = sc.nextLine().split("\\*+");
        
        // System.out.println(Arrays.toString(pattern));
        
        for(int i = 0; i < n; i++) {
            String fileName = sc.nextLine();
            if(isMatch(fileName, pattern)) {
                System.out.println("DA");
                continue;
            }
            System.out.println("NE");
        }
        
    }
    
    private static boolean isMatch(String str, String pattern[]) {
        if (!str.startsWith(pattern[0])) {
            return false;
        }
        int startIdx = str.indexOf(pattern[0]);
        str = str.substring(startIdx + pattern[0].length());
        
        if(!str.endsWith(pattern[1])) {
            return false;
        }
        return true;
    }
}
