import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import Users.User;

import static Users.User.*;

public class UserSellerManager {

    private static final String USERS_FILE = "users.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            boolean loggedIn = false;
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
                        } else {
                            System.out.println("Invalid user email. Please try again.");
                        }
                        break;
                    case 2:
                        userEmail = createUser(USERS_FILE);
                        System.out.println("User created with email " + userEmail + "\n");
                        loggedIn = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
            scanner.close();
            // do user management tasks here

        }
    }
}