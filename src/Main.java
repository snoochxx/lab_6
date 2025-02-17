import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Reader[] readers = new Reader[5];
        readers[0] = new Reader("Alice Johnson", 1001, 1, new Date(95, 4, 15), "89123456789");
        readers[1] = new Reader("Bob Smith", 1002, 2, new Date(92, 7, 20), "89098765432");
        readers[2] = new Reader("Charlie Brown", 1003, 3, new Date(88, 1, 5), "89561234567");
        readers[3] = new Reader("Diana Prince", 1004, 4, new Date(90, 11, 30), "89234567890");
        readers[4] = new Reader("Ethan Hunt", 1005, 5, new Date(85, 6, 10), "89876543210");

        for (int i = 0; i < readers.length; i++) {
            readers[i].takeBook(5);
            readers[i].takeBook("Echoes of the Forgotten", "Beneath the Silent Stars", "Whispers in the Wind");
            readers[i].returnBook(1);
            readers[i].returnBook("The Last Ember of Autumn");
        }

        // Taking
        System.out.print("Enter the number of books you want to take: ");
        int bookCount = sc.nextInt();
        sc.nextLine();
        String[] books = new String[bookCount];
        System.out.println("Enter the titles of the books:");
        for (int i = 0; i < bookCount; i++) {
            books[i] = sc.nextLine();
        }
        System.out.print("Choose a reader by entering a number: ");
        int readerIndex = sc.nextInt() - 1;
        readers[readerIndex].takeBook(books);

        // Returning
        System.out.print("Enter the number of books you want to return: ");
        int return_bookCount = sc.nextInt();
        sc.nextLine();
        String[] return_books = new String[return_bookCount];
        System.out.println("Enter the titles of the books:");
        for (int i = 0; i < return_bookCount; i++) {
            return_books[i] = sc.nextLine();
        }
        System.out.print("Choose a reader by entering a number: ");
        int return_readerIndex = sc.nextInt() - 1;
        readers[return_readerIndex].takeBook(return_books);
    }
}

class Reader {
    public String fullName;
    public int libraryCard;
    public int faculty;
    public Date dateOfBirth;
    public String phoneNumber;

    Reader(String fullName, int libraryCard, int faculty, Date dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCard = libraryCard;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int count) {
        System.out.println(this.fullName + " took " + count + " book(s).");
    }

    public void takeBook(String ... bookTitles) {
        System.out.print(fullName + " took books: ");
        for (int i = 0; i < bookTitles.length; i++) {
            System.out.print(bookTitles[i]);
            if (i < bookTitles.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void returnBook(int count) {
        System.out.println(fullName + " returned  " + count + " books.");
    }

    public void returnBook(String ... bookTitles) {
        System.out.print(fullName + " returned the books: ");
        for (int i = 0; i < bookTitles.length; i++) {
            System.out.print(bookTitles[i]);
            if (i < bookTitles.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}