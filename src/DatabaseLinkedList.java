/**
 * Created by furka on 6.03.2017.
 */
public class DatabaseLinkedList {
    private static DatabaseLinkedList ourInstance = new DatabaseLinkedList();

    public static DatabaseLinkedList getInstance() {
        return ourInstance;
    }

    private DatabaseLinkedList() {
    }
}
