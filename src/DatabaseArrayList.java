import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by furka on 6.03.2017.
 */
public class DatabaseArrayList {

    private ArrayList Books = new ArrayList<Book>();
    private ArrayList Users = new ArrayList<User>();


    private static DatabaseArrayList ourInstance = new DatabaseArrayList();

    private DatabaseArrayList() {
        // Indentationally empty
        // Implementation detail
    }

    /**
     *
     * @return Instance of ArrayList database
     */
    public static DatabaseArrayList getInstance() {
        if (ourInstance == null) {
            synchronized (DatabaseArrayList.class) { // for thread safety
                if (ourInstance == null) ourInstance = new DatabaseArrayList();// Singleton object
            }
        }
        return ourInstance;
    }
/**
 * Initializes ArayList Database
 */

    public void initializeDatabase() {
        readLibraryStaffFromCSVFile("staffList.csv");
        readLibraryBooksFromCSVFile("bookList.csv");
        readLibraryUserFromCSVFile("userList.csv");
    }

    public void readLibraryUserFromCSVFile(String filename) {
        BufferedReader userFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/int i = 0;
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

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
        } catch (Exception e) {
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

    public void readLibraryBooksFromCSVFile(String filename) {
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

    public void addUser(User newFella) throws Exception {
        if (isThereAnyMember(newFella) == true)
            throw new Exception("User Existed Already");
        else
            getUsers().add(newFella);
    }

    public void addBook(Book newBook) throws Exception {
        if (isThereAnyBook(newBook) == true)
            throw new Exception("Book Existed Already");
        else
            getBooks().add(newBook);
    }

    public boolean isThereAnyMember(User fella) {

        for (int i = 0; i < getUsers().size(); i++) {
            if (getUser(i).equals(fella) == true)
                return true;
        }
        return false;
    }

    public boolean isThereAnyBook(Book book) {
        for (int i = 0; i < getBooks().size(); i++) {
            if (getBook(i).equals(book) == true)
                return true;
        }
        return false;
    }


    public ArrayList<Book> getBooks() {

        return Books;
    }

    public ArrayList<User> getUsers() {

        return Users;
    }

    public Book getBook(int i) {
        return this.getBooks().get(i);
    }

    public User getUser(int i) {
        return this.getUsers().get(i);
    }
}
