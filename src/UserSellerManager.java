import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import Users.User;
import Users.Seller;

import static Users.Seller.writeSeller;
import static Users.User.writeUser;

public class UserSellerManager {

    private static final String USERS_FILE = "users.txt";
    private static final String SELLERS_FILE = "sellers.txt";

    public static void main(String[] args) {
        //para testes
        Seller bodaS = new Seller("Boda", "UBoda123", "boda@g.com", "123456789");
        User bodaU = new User("Bodas", "SBoda132", "boda@g.com", "123456789");
        ArrayList<Seller> sellerList = new ArrayList<Seller>();
        ArrayList<User> usersList = new ArrayList<User>();
        sellerList.add(bodaS);
        usersList.add(bodaU);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Sellers");
            System.out.println("3. Exit\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> manageUsers(usersList);
                case 2 -> manageSellers(sellerList);
                case 3 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
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
                case 1 -> {
                    System.out.println("Enter user ID:");
                    userId = scanner.next();
                    if (loginUser(userList)) {
                        System.out.println("Logged in as user with ID " + userId);
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid user ID. Please try again.");
                    }
                }
                case 2 -> {
                    userId = createUser();
                    System.out.println("Users.User created with ID " + userId);
                    loggedIn = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
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
                    if (loginSeller(sellerList)) {
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
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter NIF: ");
        String nif = scanner.nextLine();
        String sellerId = User.generateUserId(name);
        Seller seller = new Seller(name, email, address, nif);
        writeSeller(SELLERS_FILE, seller);
        scanner.close();
        return sellerId;
    }

    private static boolean loginUser(List<User> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        User user = findUserById(userList, userId);

        if (user == null) {
            System.out.println("Users.User not found.");
        } else {
            System.out.println("Logged in as: " + user.toString());
        }
        return false;
    }

    private static boolean loginSeller(List<Seller> sellerList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        String sellerId = scanner.nextLine();

        Seller seller = findSellerById(sellerList, sellerId);

        if (seller == null) {
            System.out.println("Seller.seller not found.");
        } else {
            System.out.println("Logged in as: " + seller.toString());
        }
        return false;
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