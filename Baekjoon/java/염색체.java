import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String pattern = "[A-F]{0,1}A+F+C+[A-F]{0,1}";
        
        for(int i = 0; i < n; i++) {
            String target = sc.nextLine();
            if(target.matches(pattern)) {
                System.out.println("Infected!");
            }
            else {
                System.out.println("Good");
            }
        }
        
    }
}
