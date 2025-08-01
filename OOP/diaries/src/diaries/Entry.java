package diaries;
import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public Entry(int id, String title, String body) {
        validateId(id);
        this.id = id;
        validateTitle(title);
        this.title = title;
        this.body = body;
    }

    private void validateTitle(String title) {
        if (title.length() > 50) throw new IllegalArgumentException("Title length exceeds 30 characters");
        this.title = title;
    }

    private void validateId(int id) {
        if (id <= 0) throw new IllegalArgumentException("UserID must be greater than 0");
        this.id = id;
    }

    void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    void setId(int userID) {
        validateId(userID);
        this.id = userID;
    }

    void setBody(String body) {
        this.body = body;
    }

    String getDateCreated() {
        return dateCreated.toString();
    }

    String getTitle() {
        return title;
    }

    String getBody() {
        return body;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return String.format("Entry ID: %d %nTitle: %s %nBody: %s%n", getId(), getTitle(), getBody());
    }
}