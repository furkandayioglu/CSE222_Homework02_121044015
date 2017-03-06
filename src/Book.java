/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class Book {

    private String  bookName;
    private String  Author;
    private String  bookCode;
    private int     page;
    private int     count; // Count of this book in database
    private boolean available; // true if the any copy more, false if there is no more copy available

    /**
     * No paramater Constructor
     * Creates an empty book
     */
    public Book(){
        this.setBookName(null);
        this.setAuthor(null);
        this.setPage(0);
        this.setCount(0);
        this.setAvailable(false);
        this.setBookCode(null);
    }

    /**
     * Create a new book
     * @param BookName To set Book's name
     * @param BookAuthor To set Book's Author
     * @param Page to set Page count of the book
     */
    public Book(String BookName,String BookAuthor,int Page){
        this.setBookName(BookName);
        this.setAuthor(BookAuthor);
        this.setPage(Page);
        this.setCount(1);
        this.setAvailable(true);
    }

    /**
     * Constract book
     * @param BookName
     * @param BookAuthor
     * @param page
     * @param count
     * @param available
     */
    public Book(String BookName,String BookAuthor,int page, int count,boolean available){
        this.setBookName(BookName);
        this.setAuthor(BookAuthor);
        this.setPage(page);
        this.setCount(count);
        this.setAvailable(available);
    }

    /**
     * Cosntruct book
     * @param bookName
     * @param author
     * @param bookCode
     * @param page
     */
    public Book(String bookName, String author, String bookCode, int page) {
        this.bookName = bookName;
        Author = author;
        this.bookCode = bookCode;
        this.page = page;
        this.count = 1;
        this.available = true;
    }

    /**
     * Get book sane
     * @return stirng book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Set book name
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * getAuthor name
     * @return string as Author book
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * Author set
     * @param author
     */
    public void setAuthor(String author) {
        Author = author;
    }

    /**
     * get Page count of the book
     * @return page count of book
     */
    public int getPage() {
        return page;
    }

    /**
     * set Page count of a book
     * @param page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * How many of this book in this library
     * @return the count of THIS book
     */
    public int getCount() {
        return count;
    }

    /**
     * Set count of book;
     * @param count
     */

    public void setCount(int count) {


            this.count=count;
    }

    /**
     * Checks if the book is avaliable
     * @return true if book count greater than zero
     */

    public boolean isAvailable() {
        if (this.count >=1){
            this.available=true;
        }else{
            this.available=false;
        }

        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBookCode(){ return this.bookCode;}

    public void   setBookCode(String code){ this.bookCode = code;}

    /**
     * Checks if they are equals
     * @param o is the object that we will compare with this
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(this==null)
        {
            return false;
        }
        if(this.getClass() == o.getClass()){
            Book book = (Book) o;

            return((book.getBookName()== this.getBookName()) &&
                   (this.getAuthor()==book.getAuthor()) &&
                   (this.getBookCode()==book.getBookCode()));
        }else
            return false;
    }

    /**
     *
     * @return string value according to csv format
     */
    @Override
    public String toString() {
        String bookInfo = this.getBookCode()+","+this.getBookName()+","+this.getAuthor()+","+this.getPage();
        return bookInfo;
    }
}
