package seven.managers;

import seven.features.Post;
import seven.features.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PostManager {
    private final List<Post> posts = new ArrayList<>();

    public void initializePosts() {
        posts.add(new Post(new User("Alice"), "Hello, world!"));
        posts.add(new Post(new User("Bob"), "What a lovely day!"));
        posts.add(new Post(new User("Charlie"), "I love Java!"));
        System.out.println("Initial Posts are added");
    }

    public void createPost(User currentUser, String text) {
        posts.add(new Post(currentUser, text));
        System.out.println("Post has been created.");
    }

    public void showAllPosts() {
        posts.stream()
                .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                .forEach(System.out::println);
    }

    public void likePost(int postId) {
        Post post = findPostById(postId);
        if (post != null) {
            post.addLike();
            System.out.println("Like added.");
        } else {
            System.out.println("Post with ID " + postId + " not found.");
        }
    }

    public void repost(int postId) {
        if (postId < 0) {
            System.out.println("Invalid number. Try again.");
            return;
        }
        for (Post post : posts) {
            if (post.getId() == postId) {
                post.addRepost();
                System.out.println("Repost was made.");
                return;
            }
        }
        System.out.println("Post with ID " + postId + " not found.");
    }

    public void showPostsByUser(User currentUser) {
        posts.stream().filter(p -> p.getAuthor().getId() == currentUser.getId()).forEach(System.out::println);
    }

    public void showPopularPosts() {
        posts.stream()
                .sorted(Comparator.comparingInt(Post::getLikes).thenComparing(Post::getReposts).reversed())
                .forEach(System.out::println);
    }

    public void deletePost(int postId) {
        if (postId < 0) {
            System.out.println("Invalid number. Try again.");
            return;
        }
        Iterator<Post> it = posts.iterator();
        while (it.hasNext()) {
            Post post = it.next();
            if (post.getId() == postId) {
                it.remove();
                System.out.println("Post deleted.");
                return;
            }
        }
        System.out.println("Post with ID " + postId + " not found.");
    }

    public Post findPostById(int postId) {
        return posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
    }

    public List<Post> getPosts() {
        return posts;
    }
}

