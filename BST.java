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
        
        if(root==null) {
            if(songs.hasNextLine()) {
                currentSong= songs.nextLine();
                if(currentSong.length() >= 40) {
                    currentSong= currentSong.substring(0, 40) + "...";
                }
            }
            root = new Node(currentSong);
        } 
        while(songs.hasNextLine()) {
            currentSong = songs.nextLine();
            if(currentSong.length() >= 40) {
                currentSong= currentSong.substring(0, 40) + "...";
            }
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

    public void printTree() {
        System.out.println("Your song ranking for this album is:");
        printTreeHelper(this.root, 1);
    }
    
    private int printTreeHelper(Node current, int counter) {
        if(current == null) {
            return counter;
        }
        counter = printTreeHelper(current.right, counter++);
        
        System.out.println(counter + ". " + current.data);
        
        counter = printTreeHelper(current.left, counter++);
        return counter;
    }

    public void loadTree(Scanner file) {
        int counter = 0;
        root = new Node(file.nextLine());
        while(file.hasNextLine()) {
            String song = file.nextLine();
            loadTreeHelper(song, root, counter);
            counter++;
        }
    }
    private void loadTreeHelper(String song, Node current, int counter) {
        if(root == null) {
            root = new Node(song);
            return;
        }
        else if(current == null){
             current = new Node(song);
             return;
        }
        if(counter%2 == 0) {
            loadTreeHelper(song, current.left , counter);
        } else {
            loadTreeHelper(song, current.right, counter);
        }
    }
    

}