package seven.runners;

import seven.features.Post;
import seven.features.User;
import seven.managers.CommentManager;
import seven.managers.FileManager;
import seven.managers.PostManager;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static seven.constants.Constants.POSTS_FILE;
import static seven.runners.TwitterConsoleApp.getIntInput;

public class TwitterService implements FileManager{

    private final Scanner scanner;
    private final PostManager postManager;
    private final CommentManager commentManager;

    public TwitterService(Scanner scanner) {
        this.scanner = scanner;
        this.postManager = new PostManager();
        this.commentManager = new CommentManager(postManager);
        loadPosts();
    }

    public void savePosts() {
        saveObjectsToFile(postManager.getPosts(), POSTS_FILE);
    }

    public void loadPosts() {
        File file = new File(POSTS_FILE + ".ser");
        if (!file.exists()) {
            System.out.println("No existing posts found. Starting fresh.");
            initializePosts();
            return;
        }
        List<Post> initialPosts = postManager.getPosts();
        List<Post> loadedPosts = loadObjectsFromFile(POSTS_FILE);
        if(loadedPosts != null) {
            initialPosts.clear();
            initialPosts.addAll(loadedPosts);
        }
    }

    public void createPost(User currentUser) {
        System.out.print("Enter your text: ");
        String text = scanner.nextLine().trim();
        postManager.createPost(currentUser, text);
    }

    public void showAllPosts() {
        postManager.showAllPosts();
    }

    public void likePost() {
        System.out.print("Enter the id of post you want to like: ");
        int postId = getIntInput();
        postManager.likePost(postId);
    }

    public void makeRepost() {
        System.out.print("Enter the id of post you want to repost: ");
        int postId = getIntInput();
        postManager.repost(postId);
    }

    public void showMyPosts(User currentUser) {
        postManager.showPostsByUser(currentUser);
    }

    public void showPopularPosts() {
        postManager.showPopularPosts();
    }

    public void commentPost(User currentUser) {
        System.out.print("Enter the id of post you want to comment: ");
        int postId = getIntInput();
        System.out.print("Enter your comment: ");
        String comment = scanner.nextLine().trim();
        commentManager.addComment(postId, currentUser, comment);
    }

    public void showComments() {
        System.out.print("Enter the id of post you want to see the comments: ");
        int postId = getIntInput();
        commentManager.showComments(postId);
    }

    public void deletePost() {
        System.out.print("Enter the id of post you want to delete: ");
        int postId = getIntInput();
        postManager.deletePost(postId);
    }

    private void initializePosts() {
        postManager.initializePosts();
    }
}
