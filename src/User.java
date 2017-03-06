/**
 * Created by furka on 19.02.2017.
 */

/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public interface User {
    /**
     *
     * @return User's name as String
     */
    public String getName(); // User name

    /**
     *
     * @return User's Surname as String
     */
    public String getSurname(); // User surname

    /**
     *
     * @return User's ID as String
     */
    public String UserID(); // UserID

    /**
     *
     * @param name to set User's Name
     */
    public  void   setName(String name);

    /**
     *
     * @param surname to set User's Surname
     */
    public  void   setSurname(String surname);

    /**
     * Returns userPassword
     */
    public String getPassword();

    /**
     * @param pass To Set UserPassword
     */

    public void setPassword(String pass);

    /**
     * @param username Sets userID
     */

    public void setUserID(String username);

}


