package seven.runners;

import seven.features.User;

import java.util.*;

public class TwitterConsoleApp {

    private static final Scanner scanner = new Scanner(System.in);
    private final TwitterService twitterService = new TwitterService(scanner);

    public static void main(String[] args) {
        new TwitterConsoleApp().run();
    }

    public void run() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine().trim();
        User currentUser = new User(userName);
        System.out.println("Welcome, " + currentUser.getName() + "!");
        while (true) {
            showMenu();
            int choice = getIntInput();
            switch (choice) {
                case 1 -> twitterService.createPost(currentUser);
                case 2 -> twitterService.likePost();
                case 3 -> twitterService.makeRepost();
                case 4 -> twitterService.showAllPosts();
                case 5 -> twitterService.showPopularPosts();
                case 6 -> twitterService.showMyPosts(currentUser);
                case 7 -> twitterService.commentPost(currentUser);
                case 8 -> twitterService.showComments();
                case 9 -> twitterService.deletePost();
                case 0 -> {
                    System.out.println("Exit..");
                    twitterService.savePosts();
                    scanner.close();
                    return;
                }
                default -> System.out.println("Incorrect input. Try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n=== Twitter Console ===");
        System.out.println("1. Create post");
        System.out.println("2. Like a post");
        System.out.println("3. Make a repost");
        System.out.println("4. Show all posts");
        System.out.println("5. Show popular posts");
        System.out.println("6. Show my posts");
        System.out.println("7. Comment a post");
        System.out.println("8. Show a comment");
        System.out.println("9. Delete a post");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static int getIntInput() {
        int input;
        try {
            input = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.");
            return -1;
        }
        return input;
    }
}
