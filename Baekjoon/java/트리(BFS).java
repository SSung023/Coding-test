import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    static int root = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }
        
        int remove = Integer.parseInt(br.readLine());
        Node[] tree = setUpTree(n, parents);
        
        //연결 끊기
        int parent = tree[remove].parent;
        if(remove != root) {
            tree[parent].children.remove(remove); //부모로부터 자식 노드 제거하기
        }
        
        int numOfLeaf = findNumOfLeaf(tree, n, remove);
        System.out.println(numOfLeaf);
    }
    
    private static int findNumOfLeaf(Node[] tree, int n, int remove) {
        if(root == remove) {
            return 0;
        }
        
        int numOfLeaf = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        isVisited[root] = true;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> children = new ArrayList<>(tree[cur].children);
            
            if(children.size() == 0) {
                numOfLeaf++;
            }
            
            for(int child : children) {
                if(isVisited[child]) {
                    continue;
                }
                isVisited[child] = true;
                queue.add(child);
            }
        }
        return numOfLeaf;
    }
    
    private static Node[] setUpTree(int n, int[] parents) {
        Node[] tree = new Node[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new Node(i);
        }
        
        for(int i = 0; i < n; i++) {
            int parent = parents[i];
            if(parent == -1) {
                root = i;
                continue;
            }
            //부모 노드 설정
            tree[i].parent = parent;
            tree[parent].children.add(i);
        }
        
        return tree;
    }
    
}

class Node {
    int value;
    int parent;
    Set<Integer> children;
    
    public Node(int value) {
        this.value = value;
        this.parent = -1;
        this.children = new HashSet<>();
    }
    
    @Override
    public String toString() {
        return "value: " + value + " parent: " + parent + "  children: " + children.toString();
        // return String.format("parent: %d", parent);
    }
}
