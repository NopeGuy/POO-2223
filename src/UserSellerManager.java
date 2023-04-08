import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import Users.User;
import Users.Buy;
import Users.Sell;

import static Users.User.*;
import static Users.Buy.*;
import static Users.Sell.*;

public class UserSellerManager {

    private static final String USERS_FILE = "users.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            boolean loggedIn = false;
            String userId = "";
            String userEmail = "";
            while (!loggedIn) {
                System.out.println("\\Welcome to Vintagio/");
                System.out.println("Choose an option:");
                System.out.println("1. Log in");
                System.out.println("2. Create new user");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter user email:");
                        userEmail = scanner.next();
                        ArrayList<User> usersList = readUsers(USERS_FILE);
                        if (loginUser(userEmail, usersList)) {
                            System.out.println("Logged in as user with email " + userEmail + "\n");
                            loggedIn = true;
                            running = false;
                        } else {
                            System.out.println("Invalid user email. Please try again.");
                        }
                        break;
                    case 2:
                        userId = createUser(USERS_FILE);
                        System.out.println("User created with id " + userId + "\n");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
            // do user management tasks here
            System.out.println("Welcome to the shop, here to 1)buy or 2)sell?");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    buyArticle();
                    break;
                case 2:
                    sellArticle();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            scanner.close();
        }
    }
}