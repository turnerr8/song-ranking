import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main{

public static void main(String[] args) throws FileNotFoundException {
    Scanner console = new Scanner(System.in);
    Scanner text = new Scanner(new File("./song_files/phoebe_bridgers.txt"));
    BST phoebe = new BST();
    phoebe.createTree(text);
    phoebe.printTree(phoebe.root);
}



}
