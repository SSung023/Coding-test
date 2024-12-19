import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String target = sc.nextLine();
        String pattern = "(100+1+|01)+";
        if(target.matches(pattern)) {
            System.out.println("SUBMARINE");
        }
        else {
            System.out.println("NOISE");
        }
    }
}
