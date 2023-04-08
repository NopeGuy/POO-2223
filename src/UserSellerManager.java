import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import Users.User;
import Users.Seller;

import static Users.Seller.readSellers;
import static Users.Seller.writeSeller;
import static Users.User.readUsers;
import static Users.User.writeUser;

public class UserSellerManager {

    private static final String USERS_FILE = "users.txt";
    private static final String SELLERS_FILE = "sellers.txt";

    public static void main(String[] args) {
        //para testes
        //Seller bodaS = new Seller("Boda", "SBoda123", "boda@g.com", "123456789");
        //User bodaU = new User("Bodas", "UBoda132", "boda@g.com", "123456789");
        ArrayList<User> usersList = readUsers(USERS_FILE);
        ArrayList<Seller> sellerList = readSellers(SELLERS_FILE);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Sellers");
            System.out.println("3. Exit\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manageUsers(usersList);
                    break;
                case 2:
                    manageSellers(sellerList);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }


    private static void manageUsers(List<User> userList) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String userId = "";
        while (!loggedIn) {
            System.out.println("Choose an option:");
            System.out.println("1. Log in");
            System.out.println("2. Create new user");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user ID:");
                    userId = scanner.next();
                    if (loginUser(userId, userList)) {
                        System.out.println("Logged in as user with ID " + userId);
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid user ID. Please try again.");
                    }
                    break;
                case 2:
                    userId = createUser();
                    System.out.println("User created with ID " + userId);
                    loggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        // do user management tasks here
        scanner.close();
    }


    private static void manageSellers(List<Seller> sellerList) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String sellerId = "";
        while (!loggedIn) {
            System.out.println("Choose an option:");
            System.out.println("1. Log in");
            System.out.println("2. Create new seller");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter seller ID:");
                    sellerId = scanner.next();
                    if (loginSeller(sellerId, sellerList)) {
                        System.out.println("Logged in as seller with ID " + sellerId);
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid seller ID. Please try again.");
                    }
                    break;
                case 2:
                    sellerId = createSeller();
                    System.out.println("Seller created with ID " + sellerId);
                    loggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        // do seller management tasks here
        scanner.close();
    }

    private static String createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter NIF:");
        String nif = scanner.next();
        String userId = User.generateUserId(name);
        User user = new User(name, userId, email, nif);
        writeUser(USERS_FILE, user);
        scanner.close();
        return userId;
    }

    private static String createSeller() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter NIF: ");
        String nif = scanner.next();
        String sellerId = Seller.generateSellerId(name);
        Seller seller = new Seller(name, sellerId, email, nif);
        writeSeller(SELLERS_FILE, seller);
        scanner.close();
        return sellerId;
    }

    private static boolean loginUser(String userId, List<User> userList) {

        User user = findUserById(userList, userId);

        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean loginSeller(String sellerId, List<Seller> sellerList) {

        Seller seller = findSellerById(sellerList, sellerId);

        if (seller == null) {
            return false;
        } else {
            return true;
        }
    }

    private static User findUserById(List<? extends User> userList, String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private static Seller findSellerById(List<? extends Seller> sellerList, String sellerId) {
        for (Seller seller : sellerList) {
            if (seller.getSellerId().equals(sellerId)) {
                return seller;
            }
        }
        return null;
    }
}