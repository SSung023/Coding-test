import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        String pattern = "(100+1+|01)+";
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if(str.matches(pattern)) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}
