import java.util.Scanner;

/*
 * Convert your list-based library from the previous section into a map-based library. 
 * In your map-based list of books, use the title of the book as the key and the book object as the value. 
 * Also add a new option to your loop to support the following functionality:

Ask the user if they want to add a book or look up an existing book
If they want to look up an existing book, ask them for the title of the book
Using the title they enter, look up the book in your map-based list
If you find the book, display the book's information and continue your loop
If you don't find the book, tell the user your library doesn't have that book and continue your loop
 */
public class LibraryRunner {

    public static Scanner sc = new Scanner(System.in);
    public static boolean repeat = true;
    public static String addBookMsg = "\n-- Would you like to: \n 1. Add a book \n 2. Look up an existing book \n 3. Print all books \n 4. Exit \n \nType the number of the option you choose from above:";
    public static String addBookMsgAgain = "\n-- Would you like to: \n 1. Add another book \n 2. Look up an existing book \n 3. View all books \n 4. Exit \n \nType the number of the option you choose from above:";
    
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Virtual Book Library, where you can create and look up books!");
        intro();
    }

    public static void intro() {  
        while (repeat) {
            addBookMsg = Library.bookMap.isEmpty() ? addBookMsg : addBookMsgAgain;
            System.out.println(addBookMsg);
            int addBookAnswer = sc.nextInt();
            
            switch (addBookAnswer) {
                case 1:
                    String str = sc.nextLine();
                    addBook();
                    break;
                case 2:
                    String str1 = sc.nextLine();
                    lookUpBook();
                    break;
                case 3:
                    Library.printBooks();
                    intro();
                    break;
                case 4:       
                    System.out.println("\nGoodbye!"); 
                    repeat = false;
                    System.exit(0);
                    break;       
            }
                // Loop back to beginning for user input
                String str = sc.nextLine();
        }
    }

    public static void addBook() {
        System.out.println("\nWhat would you like this book to be called?");
        String title = sc.nextLine();
        System.out.println("\nWhat genre is this book?");
        String genre = sc.nextLine();
        System.out.println("\nHow many pages does this book have?");
        int numPages = sc.nextInt();

        Book newBook = new Book(title, genre, numPages);
        Library.bookMap.put(newBook.getTitle(), newBook);

        System.out.println("\n***** Book as been added! *****");
    }

    public static void lookUpBook() {
        System.out.println("\nWhat is the title of the book you are searching?");
        String title = sc.nextLine();

        if (Library.bookMap.containsKey(title)) {
            System.out.println("\nThis is the book you are looking for:\n" + Library.bookMap.get(title));
            intro();
        } else {
            System.out.println("\n*** \nSorry! We don't have that book in our records.... \n***");
            intro();
        }
    }
}
