import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main{

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        BST tree = new BST();
        String filePath = filePath(console);
        //phoebe.createTree(text);
        //phoebe.printTree(phoebe.root);
    }

    private static String filePath(Scanner console) throws FileNotFoundException{
        //filepath for artist
        String filePath = "./song_files/";

        System.out.printf("%s%n%s%n", "PLEASE SELECT ARTIST:", "~~~~~~~~~~~~~~~~~~~");
        printFiles(filePath);
        System.out.println("~~~~~~~~~~");

        System.out.print("Choice: ");
        String artist = console.nextLine();
        filePath += artist.toLowerCase().replace(" ", "_") + "/";


        System.out.printf("%s%n%s%n", "PLEASE SELECT ALBUM:", "~~~~~~~~~~~~~~~~~~~~~~");
        printFiles(filePath);
        System.out.println("~~~~~~~~~~~");
        System.out.print("Choice: ");
        String album = console.nextLine();
        filePath += album.toLowerCase().replace(" ", "_");


        return filePath;

    }

    private static void printFiles(String filePath) throws FileNotFoundException{
        File fileNames = new File(filePath);
        File[] fileNamesArray = fileNames.listFiles();
        for(int i = 0; i<fileNamesArray.length; i++) {
            System.out.println(fileNamesArray[i].getName().replace(".txt", "").replace('_', ' ').toUpperCase());
        }
    }


}
