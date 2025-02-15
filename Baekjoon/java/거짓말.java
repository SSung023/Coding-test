import java.io.*;
import java.util.*;


class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        
        int[] trueParents = new int[n + 1]; // 진실 root
        int[] partyParents = new int[n + 1]; // 각 파티의 root
        for(int i = 0; i <= n; i++) {
            trueParents[i] = i;
            partyParents[i] = i;
        }
        int[] party = new int[m];
        
        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        int firstKnow = 0;
        // 진실을 아는 사람이 있다면 
        if(knowCnt > 0) {
            firstKnow = Integer.parseInt(st.nextToken());
            for(int i = 0; i < knowCnt - 1; i++) {
                int know = Integer.parseInt(st.nextToken());
                union(firstKnow, know, trueParents);
            }
        }
        
        // 파티에 오는 사람들을 조사해서 각 파티마다 union을 해준다
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int participantCnt = Integer.parseInt(st.nextToken()); // 파티에 참여하는 인원
            
            int firstPerson = Integer.parseInt(st.nextToken());
            for(int k = 0; k < participantCnt - 1; k++) {
                int next = Integer.parseInt(st.nextToken());
                union(firstPerson, next, trueParents);
                union(firstPerson, next, partyParents);
            }
            party[i] = find(firstPerson, partyParents);
        }
        
        int answer = 0;
        int trueRoot = find(firstKnow, trueParents);
        for(int i = 0; i < m; i++) {
            int target = party[i];
            int targetRoot = find(target, trueParents);
            if(trueRoot != targetRoot) {
                answer++;
            }
        }
        
        // System.out.println(Arrays.toString(trueParents));
        // System.out.println(Arrays.toString(party));
        System.out.println(answer);
    }
    
    private static int find(int node, int[] parents) {
        if(parents[node] != node) {
            parents[node] = find(parents[node], parents);
        }
        return parents[node];
    }
    
    private static boolean union(int n1, int n2, int[] parents) {
        int root1 = find(n1, parents);
        int root2 = find(n2, parents);
        if(root1 == root2)  return false;
        
        if(root1 < root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
        
        return true;
    }
}
