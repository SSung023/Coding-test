import java.util.*;

class Solution {
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        List<Node> nodes = initNodes(nodeinfo);
        Node root = constructTree(nodes);
        // System.out.println(nodes);
        // System.out.println(root);
        
        preOrder(root);
        postOrder(root);
        
        return new int[][] {
            pre.stream().mapToInt(Integer::intValue).toArray(),
            post.stream().mapToInt(Integer::intValue).toArray()
        };
    }
    
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        pre.add(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        post.add(node.value);
    }
    
    private List<Node> initNodes(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            int[] info = nodeinfo[i];
            Node node = new Node(i + 1, info[1], info[0]);
            nodes.add(node);
        }
        Collections.sort(nodes);
        return nodes;
    }
    
    private Node constructTree(List<Node> nodes) {
        Node root = nodes.get(0);
        for(int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        return root;
    }
    
    private void insert(Node root, Node cur) {
        // x값이 더 작다면 왼쪽 자식
        if(root.x > cur.x) {
            if(root.left == null) {
                root.left = cur;
            } else {
                insert(root.left, cur);
            }
        } else { // x값이 더 크다면 오른쪽 자식
            if(root.right == null) {
                 root.right = cur;
            } else {
                insert(root.right, cur);
            }
        }
    }
    
    class Node implements Comparable<Node>{
        int value;
        int y;
        int x;
        Node left;
        Node right;
    
        public Node(int value, int y, int x) {
            this.value = value;
            this.y = y;
            this.x = x;
            this.left = null;
            this.right = null;
        }
    
        @Override
        public int compareTo(Node other) {
            int gapY = other.y - this.y;
            if(gapY != 0) return gapY;
            return this.x - other.x;
        }
    
        public String toString() {
            return String.format("num: %d, y: %d, x: %d\n", value, y, x);
        }
    }
}
