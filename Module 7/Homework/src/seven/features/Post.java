package seven.features;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static seven.constants.Constants.MAX_CHARS;

public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final User author;
    private final String content;
    private int likes;
    private int reposts;
    private final int id;
    private static int NEXT_ID = 1;
    private final LocalDateTime createdAt;
    private final List<Comment> comments = new ArrayList<>();

    public Post(User author, String content) {
        this.author = author;
        this.content = content.length() > MAX_CHARS ? content.substring(0, MAX_CHARS) : content;
        this.likes = 0;
        this.reposts = 0;
        this.id = NEXT_ID++;
        this.createdAt = LocalDateTime.now();
    }

    public void addLike() {
        likes++;
    }

    public void addRepost() {
        reposts++;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void showComments() {
        if (comments.isEmpty()) {
            System.out.println("No comments yet.");
            return;
        }
        System.out.println("\nComments:");
        comments.forEach(System.out::println);
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getReposts() {
        return reposts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Post [id: %d]\nAuthor: %s\nContent: \"%s\"\nLikes: %d | Reposts: %d\nPosted: %s\nComments: %d\n",
                id, author.getName(), content, likes, reposts, createdAt.format(formatter), comments.size());
    }
}
