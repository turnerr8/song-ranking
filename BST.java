public class BST {
    
    public static class Node {
        String data;
        Node left;
        Node right;
        Node parent;
    }

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;

    }

    public Node root;

    public BST() {
        root = null;
    }

    public void insert(String data) {
        if (root == null) {
            root = new Node(data);
        } else {
            
        }
    }
}