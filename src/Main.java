import javafx.scene.chart.PieChart;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by furka on 26.02.2017.
 */
public class Main {

    public static void main(String[] argv) {

        Scanner parse = new Scanner(System.in);
        DatabaseArray db = DatabaseArray.getInstance();
        PrintStream print = new PrintStream(System.out);
        String username;
        String pass;
        db.initializeDatabase();

        print.println("CSE 222 Library Management System");
        print.println("*********************************");
        print.printf("Enter User Name : ");
        username = parse.nextLine();
        print.printf("Enter Password : ");
        pass = parse.nextLine();


        while (db.isValidUser(username, pass) != true) {
            print.println("Incorrect username ") ;
            print.printf("Enter User Name : ");
            username = parse.nextLine();
            print.printf("Enter Password : ");
            pass = parse.nextLine();

        }

        User user = db.getUser(username,pass);

        if(user instanceof LibraryStaff)
            libraryStaff(user); // a test method to show library staff stuff
        else if(user instanceof  LibraryUser)
            libraryUser(user); // a test method to show librar user stuff


        db.writeToFiletheRecords();

        print.println("Check CSV files to see results of test after working");
        print.println("Programm is ending here");
        print.println("Thanks to control it");

    }

    private static void libraryUser(User user) {

        LibraryStaff libStaff = (LibraryStaff) user;

        LibraryUser user1 = new LibraryUser("hasanAli","yuceL1923");
        LibraryUser user2 = new LibraryUser("ricardoQuaresme","q71903");
        LibraryUser user3 = new LibraryUser("Senol","Gunes","senolHoca","19031961");

        Book book1 = new Book("Anna Karenina","Lev Tostoy","579183",423);
        Book book2 = new Book("Don Quixote","Cervantes","785646",321);



        libStaff.addBook(book1);
        libStaff.addBook(book2);

        libStaff.addUser(user1);
        libStaff.addUser(user2);
        libStaff.addUser(user3);

        libStaff.deleteBook(new Book("Don Quixote","Cervantes","785646",321));

        libStaff.giveBook(DatabaseArray.getInstance().getBook(2),user1);

    }

    private static void libraryStaff(User user) {
        LibraryUser libUser= (LibraryUser) user;

        libUser.borrowABook(new Book("NUTUK","Mustafa Kemal Ataturk","605649",543));
        libUser.returnBook(new Book("NUTUK","Mustafa Kemal Ataturk","605649",543));
    }
}
