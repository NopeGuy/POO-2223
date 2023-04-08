package Users;

import Items.Artigo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static Users.User.*;

public class Sell {
    public static void sellArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running) {
            System.out.println("Select which article to sell: 1) Shoes, 2) T-Shirts, 3) Handbags, 0) Exit:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:

                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
