import java.util.HashMap;

public class Library {

    public static HashMap<String, Book> bookMap = new HashMap<String, Book>();

    public static void printBooks() {
        // If there are books in the library:
        System.out.println("");
        System.out.println("");
        System.out.println("These are the books in your library!");
        System.out.println("|");
        System.out.println("V");
        // Print library books:
        for (String title: bookMap.keySet()) {
            System.out.println(title);
            System.out.println(bookMap.get(title));
        }
        // Else, print sad face or ASCII art
    }
}
