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
        
        int numOfLeaf = findNumOfLeaf(tree, new boolean[n], root, remove);
        System.out.println(numOfLeaf);
    }
    
    //DFS ver
    private static int findNumOfLeaf(Node[] tree, boolean[] isVisited, int cur, int remove) {
        int numOfLeaf = 0;
        if(remove == root) {
            return 0;
        }
        
        Node curNode = tree[cur];
        List<Integer> nextNodes = new ArrayList<>(curNode.children);
        
        if(nextNodes.size() == 0) {
            return numOfLeaf + 1;
        }
        
        for(int next : nextNodes) {
            if(isVisited[next]) continue;
            isVisited[next] = true;
            numOfLeaf += findNumOfLeaf(tree, isVisited, next, remove);
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
