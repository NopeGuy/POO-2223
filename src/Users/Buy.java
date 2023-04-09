package Users;

import Items.Artigo;
import Items.Mala;
import Items.Sapatilha;
import Items.Tshirt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static Items.Mala.printHandbagToFile;
import static Items.Mala.printHandbagToFileHistory;
import static Items.Sapatilha.printShoeToFile;
import static Items.Sapatilha.printShoetoFileHistory;
import static Items.Tshirt.printTshirtToFile;
import static Items.Tshirt.printTshirtToFileHistory;
import static Users.Purchases.printAllSalesExceptUser;

public class Buy {
    public static void buyArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String BUY_FILE = "buyhistory.txt";

        while(running) {
            System.out.println("Select if you want to see the stock 1) or buy something 2):");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printAllSalesExceptUser(userEmail);
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
