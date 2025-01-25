import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                pq.add(x);
                continue;
            }
            if(pq.isEmpty()) {
                System.out.println("0");
            } else {
                int min = pq.poll();
                System.out.println(min);
            }
            
        }
    }
}
