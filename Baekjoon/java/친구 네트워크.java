import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testcase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testcase; i++) {
            int f = Integer.parseInt(br.readLine());
            solution(f, br);
        }
    }
    
    private static void solution(int f, BufferedReader br) throws IOException {
        Map<String, String> parent = new HashMap<>(); // 본인 이름, root 이름
        Map<String, Integer> size = new HashMap<>(); // 본인이름, 속하는 그룹의 사이즈
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < f; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            
            parent.putIfAbsent(p1, p1);
            parent.putIfAbsent(p2, p2);
            size.putIfAbsent(p1, 1);
            size.putIfAbsent(p2, 1);
            
            union(parent, size, p1, p2);
            sb.append(size.get(find(parent, p1))).append("\n");
        }
        System.out.print(sb);
    }
    
    private static void union(Map<String, String> parent, Map<String, Integer> size, String p1, String p2) {
        String root1 = find(parent, p1);
        String root2 = find(parent, p2);
        
        if(!root1.equals(root2)) {
            if(root1.compareTo(root2) < 0) {
                parent.put(root2, root1);
                size.put(root1, size.get(root1) + size.get(root2));
            } else {
                parent.put(root1, root2);
                size.put(root2, size.get(root1) + size.get(root2));
            }
        }
    }
    
    private static String find(Map<String, String> parent, String person) {
        if(!parent.get(person).equals(person)) {
            parent.put(person, find(parent, parent.get(person)));
        }
        return parent.get(person);
    }
}
