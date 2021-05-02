import java.io.File;
import java.util.Scanner;

public class BST {
    Scanner console = new Scanner(System.in);

    
    class Node {
        String data;
        Node left;
        Node right;
        Node parent;
    


        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;

        }
    }

    public Node root;

    public BST() {
        root = null;
    }

    public void createTree(Scanner songs) {
        String currentSong = "";
        if(songs.hasNextLine()) {
            currentSong= songs.nextLine();
        }
        if(root==null) {
            root = new Node(currentSong);
        } 
        while(songs.hasNextLine()) {
            currentSong = songs.nextLine();
            treeCont(currentSong, root);
            

        }
    }

    private void treeCont(String currentSong, Node current) {
        System.out.println("Which do you like more?");
        System.out.println("[A] " + current.data + " or [B] " + currentSong);
        char choice = console.next().charAt(0);
        if('a' == Character.toLowerCase(choice)) {
            if(current.left == null) {
            current.left = new Node(currentSong);
            return;
            }
            treeCont(currentSong, current.left);
            return;
        } else {
            if(current.right == null) {
                current.right = new Node(currentSong);
                return;
            }
            treeCont(currentSong, current.right);
            return;
        }

    }

    public void printTree(Node current) {
        if(current == null) {
            return;
        }
        printTree(current.right);
        System.out.println(current.data);
        printTree(current.left);
    }
    

}