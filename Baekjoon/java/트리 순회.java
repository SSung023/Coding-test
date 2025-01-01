import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n + 1];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            if(tree[root - 'A'] == null) {
                tree[root - 'A'] = new Node(root);
            }
            
            // 왼쪽 자식
            if(left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }
            
            // 오른쪽 자식
            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }
        preOrder(tree[0]);
        System.out.println();
        
        inOrder(tree[0]);
        System.out.println();
        
        postOrder(tree[0]);
        System.out.println();
    }
    
    public static void preOrder(Node node) {
        if(node == null)    return;
        
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public static void inOrder(Node node) {
        if(node == null)    return;
        
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    
    public static void postOrder(Node node) {
        if(node == null)    return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
    
    
}
class Node {
        char value;
        Node left;
        Node right;
        
        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
