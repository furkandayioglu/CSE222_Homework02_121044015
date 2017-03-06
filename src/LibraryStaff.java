/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class LibraryStaff implements User {

    private String name;
    private String surname;
    private String password;
    private String username;
    private DatabaseArray db = DatabaseArray.getInstance();

    /**
     * No parameter constructor
     */
    public LibraryStaff() {

    }

    /**
     * Creates staff with username and passwprd
     * @param password
     * @param username
     */
    public LibraryStaff(String password, String username) {
        this.password = password;
        this.username = username;
    }

    /**
     * Creates total Staff
     * @param name
     * @param surname
     * @param password
     * @param username
     */
    public LibraryStaff(String name, String surname, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
    }


    /**
     *
     * @return name of staff
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return surname of staff
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     *
     * @return username of staff
     */
    public String UserID() {
        return this.username;
    }

    /**
     *
     * @param name to set User's Name
     */
    public void setName(String name) {
            this.name=name;
    }

    /**
     *
     * @param surname to set User's Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return paswaord of staff
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param pass To Set UserPassword
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     *
     * @param username Sets userID
     */
    public void setUserID(String username) {
        this.username=username;
    }

    /**
     * checks if staffs are same
     * @param o object
     * @return true if staffs are same
     */
    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;

        }
        if(this.getClass() == o.getClass()){
            LibraryStaff lS = (LibraryStaff) o;
            return ((this.UserID() == lS.UserID()) &&
                    (this.getPassword() == lS.getPassword()));
        }else
            return false;

    }

    /**
     *
     * @return a string suitable to csv format
     */
    @Override
    public String toString() {
        String staff =this.getName()+","+this.getSurname()+","+this.UserID()+","+this.getPassword();
        return staff;
    }

    /**
     *  Gives a book to given user
     * @param book that will be given
     * @param libUser that will read book
     * @return true if giving operation was successfull
     */
    public boolean giveBook(Book book, LibraryUser libUser){

         if(DatabaseArray.getInstance().isThereAnyBook(book)==true && book.isAvailable() == true && DatabaseArray.getInstance().isThereAnyMember(libUser) == true){
                libUser.setRecentBookCode(book.getBookCode());
                book.setCount(book.getCount()-1);
         }
        return false;
    }

    /**
     * Adds a book to database
     * @param newBook to add
     */
    public void addBook(Book newBook) {
        try {
            DatabaseArray.getInstance().addBook(newBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete book from data base
     * @param delete to delete
     */
    public void deleteBook(Book delete){
        DatabaseArray.getInstance().deleteBook(delete);
    }

    /**
     * ADd user to database
     * @param newFella to add
     */
    public void addUser(User newFella){

        DatabaseArray.getInstance().addUser(newFella);
    }
}
