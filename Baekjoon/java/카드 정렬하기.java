import java.util.*;
import java.io.*;

class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] cards = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
            pq.add(cards[i]);
        }
        
        
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            answer += (a + b);
        }
        System.out.println(answer);
    }
}
