package seven.managers;

import seven.features.Comment;
import seven.features.Post;
import seven.features.User;

public class CommentManager {
    private final PostManager postManager;

    public CommentManager(PostManager postManager) {
        this.postManager = postManager;
    }

    public void addComment(int postId, User user, String commentText) {
        Post post = postManager.findPostById(postId);
        if (post != null) {
            post.addComment(new Comment(user, commentText));
            System.out.println("Comment was added.");
        } else {
            System.out.println("Post with ID " + postId + " not found.");
        }
    }

    public void showComments(int postId) {
        Post post = postManager.findPostById(postId);
        if (post != null) {
            post.showComments();
        } else {
            System.out.println("Post with ID " + postId + " not found.");
        }
    }
}
