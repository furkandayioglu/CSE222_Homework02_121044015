import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by furka on 6.03.2017.
 */
public class DatabaseLinkedList {

    LinkedList<Book> Books = new LinkedList<Book>();
    LinkedList<User> Users = new LinkedList<User>();

    private static DatabaseLinkedList ourInstance = new DatabaseLinkedList();

    public static DatabaseLinkedList getInstance() {
        if (ourInstance == null) {
        synchronized (DatabaseLinkedList.class) { // for thread safety
            if (ourInstance == null) ourInstance = new DatabaseLinkedList();// Singleton object
        }
    }
        return ourInstance;
    }

    private DatabaseLinkedList() {
    }

    public void addUser(User newFella){

        Users.add(newFella);

    }

    public void addBook(Book newBook){
        Books.add(newBook);
    }

    public LinkedList<Book> getBooks(){
        return Books;
    }

    public LinkedList<User> getUsers(){
        return Users;

    }

    public boolean isThereAnyBook(Book book){

        for(int i = 0; i< Books.size();i++){
            if(Books.get(i).equals(book) == true )
                return true;
        }
        return false;
    }

    public boolean isThereAnyUser(User user){

        for(int i = 0 ;i< Users.size();i++){
            if(Users.get(i).equals(user)== true)
                    return true;
        }
        return false;
    }

    public void readLibraryUserFromCSVFile(String filename) {
        BufferedReader userFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = 0;
        try {
            userFile = new BufferedReader(new FileReader(filename));

            while ((line = userFile.readLine()) != null) {
                User temp = new LibraryUser();
                String[] userInfo = line.split(split);
                temp.setName(userInfo[0]);
                temp.setSurname(userInfo[1]);
                temp.setUserID(userInfo[2]);
                temp.setPassword(userInfo[3]);
                this.addUser(temp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userFile != null) {
                try {
                    userFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * Read Staff from csv file
     * @param filename to read file
     */
    public void readLibraryStaffFromCSVFile(String filename) {
        BufferedReader userFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

        try {
            userFile = new BufferedReader(new FileReader(filename));

            while ((line = userFile.readLine()) != null) {
                User temp = new LibraryStaff();
                String[] userInfo = line.split(split);
                temp.setName(userInfo[0]);
                temp.setSurname(userInfo[1]);
                temp.setUserID(userInfo[2]);
                temp.setPassword(userInfo[3]);
                this.addUser(temp);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userFile != null) {
                try {
                    userFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * Read books from csv file
     * @param filename
     */
    public void readBooksFromCsvFile(String filename) {
        BufferedReader bookFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = 0;
        try {
            bookFile = new BufferedReader(new FileReader(filename));

            while ((line = bookFile.readLine()) != null) {
                Book temp = new Book();
                String[] bookinfo = line.split(split);
                temp.setBookCode(bookinfo[0]);
                temp.setBookName(bookinfo[1]);
                temp.setAuthor(bookinfo[2]);
                temp.setPage(Integer.parseInt(bookinfo[3]));
                temp.setAvailable(true);
                this.addBook(temp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bookFile != null) {
                try {
                    bookFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
