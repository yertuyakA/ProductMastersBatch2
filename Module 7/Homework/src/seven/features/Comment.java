package seven.features;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static seven.constants.Constants.MAX_CHARS;

public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final User author;
    private final String content;
    private final LocalDateTime createdAt;

    public Comment(User author, String content) {
        this.author = author;
        this.content = content.length() > MAX_CHARS ? content.substring(0, MAX_CHARS) : content;
        this.createdAt = LocalDateTime.now();
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Comment Author: %s\nContent: \"%s\"\nCreated at: %s\n",
                author.getName(), content, createdAt.format(formatter));
    }
}
