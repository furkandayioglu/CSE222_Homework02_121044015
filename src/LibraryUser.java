/**
 * Created by furka on 19.02.2017.
 */

/**
 * @author Furkan Sergen Dayioglu
 *         Course : CSE222 Data Structures and Algorithms
 *         StudentID: 121044015
 */
public class LibraryUser implements User {

    private String name;
    private String surname;
    private String password;
    private String username;
    private String recentBookCode;
    private DatabaseArray db = DatabaseArray.getInstance();

    /**
     * No parameter Constructor
     */
    public LibraryUser() {

        setName(null);
        setSurname(null);
        setSurname(null);
        setUserID(null);
        setPassword(null);
        setRecentBookCode(null);
    }

    /**
     * Just construct a book with usename and password
     *
     * @param username
     * @param password
     */
    public LibraryUser(String username, String password) {
        this.password = password;
        this.username = username;
    }

    /**
     * Construct an almost full user with these parameters
     *
     * @param name
     * @param surname
     * @param username
     * @param password
     */
    public LibraryUser(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.recentBookCode = null;
    }

    /**
     * Cosntructs a total user with whole parameters
     *
     * @param name
     * @param surname
     * @param username
     * @param password
     * @param recentBookCode
     */
    public LibraryUser(String name, String surname, String username, String password, String recentBookCode) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.recentBookCode = recentBookCode;
    }

    /**
     * get name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get surname
     *
     * @return surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * returns user id
     *
     * @return username
     */
    public String UserID() {
        return this.username;
    }

    /**
     * @param name to set User's Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param surname to set User's Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param pass To Set UserPassword
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     * @param username Sets userID
     */
    public void setUserID(String username) {
        this.username = username;
    }

    /**
     * Get recentBookCode if user has bOrrOwed a book from library
     *
     * @return bookCode
     */
    public String getRecentBookCode() {
        return this.recentBookCode;
    }

    /**
     * Set book code if user borrows a book
     *
     * @param code set if user BORROWs a book
     */
    public void setRecentBookCode(String code) {
        this.recentBookCode = code;
    }

    /**
     * Check equality the object and this
     *
     * @param o object
     * @return true if this and o equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() == o.getClass()) {
            LibraryUser lU = (LibraryUser) o;
            return ((this.UserID() == lU.UserID()) && (this.getPassword() == lU.getPassword()));

        } else return false;

    }

    /**
     * @return a string that suiatable to print into csv file
     */
    @Override
    public String toString() {
        String libraryUser = this.getName() + "," + this.getSurname() + "," + this.UserID() + "," + this.getPassword();

        return libraryUser;
    }

    /**
     *  What if user want to ask a BORROW a book
     * @param book that user want to borrow
     */
    public void borrowABook(Book book) {

        if ((DatabaseArray.getInstance().isThereAnyBook(book) == true && this.recentBookCode == null) && (DatabaseArray.getInstance().getBook(book)).getCount() > 0) {
            this.setRecentBookCode(book.getBookCode());
            DatabaseArray.getInstance().getBook(book).setCount(DatabaseArray.getInstance().getBook(book).getCount() - 1);
        }

    }

    /**
     * Returnes borrowed book to LIBRARY
     * @param book
     */
    public void returnBook(Book book) {
        if (DatabaseArray.getInstance().isThereAnyBook(book) == true) {
            DatabaseArray.getInstance().getBook(book).setCount(DatabaseArray.getInstance().getBook(book).getCount() + 1);
        } else {
            try {
                DatabaseArray.getInstance().addBook(book);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
