import java.io.*;
import java.util.*;

class Main {
    static boolean[] isVisited;
    static List<Integer>[] tree;
    static int[] subtreeSize;  // 각 노드의 서브트리 크기를 저장
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        isVisited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        subtreeSize = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 간선 입력
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }
        
        // 루트 기준으로 트리 방향 설정하고 서브트리 크기 계산
        setUpDirectedTree(root);
        calculateSubtreeSize(root);
        
        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int subRoot = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[subRoot]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    
    // 서브트리 크기를 미리 계산
    public static int calculateSubtreeSize(int node) {
        subtreeSize[node] = 1;  // 자기 자신
        
        for(int child : tree[node]) {
            subtreeSize[node] += calculateSubtreeSize(child);
        }
        
        return subtreeSize[node];
    }
    
    // 트리를 단방향(부모->자식)으로 변환
    public static void setUpDirectedTree(int node) {
        isVisited[node] = true;
        List<Integer> children = new ArrayList<>();
        
        for(int next : tree[node]) {
            if(!isVisited[next]) {
                children.add(next);
                setUpDirectedTree(next);
            }
        }
        
        tree[node] = children;
    }
}
