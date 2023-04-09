package Users;

import Items.*;

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
import static Users.User.*;

public class Sell {
    public static void sellArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String ARTICLES_FILE = "stock/" + userEmail + ".txt";
        String SELL_FILE = "sellhistory.txt";

        while(running) {
            System.out.println("Select which article to sell: 1) Shoes, 2) Premium Shoes, 3) Handbags, 4) Premium Handbags, 5) T-Shirts, 0) Exit:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Sapatilha nova1 = Sapatilha.createShoe();
                    printShoeToFile(nova1, ARTICLES_FILE);
                    printShoetoFileHistory(userEmail, nova1, SELL_FILE);
                    break;
                case 2:
                    /*
                    SapatilhaPremium nova2 = SapatilhaPremium.createPremiumShoe();
                    printPremiumShoeToFile(nova2, ARTICLES_FILE); */
                    break;
                case 3:
                   Mala nova3 = Mala.createHandbag();
                    printHandbagToFile(nova3, ARTICLES_FILE);
                    printHandbagToFileHistory(userEmail, nova3, SELL_FILE);
                    break;
                case 4:
                    /*
                    MalaPremium nova4 = MalaPremium.createPremiumHandbag();
                    printPremiumHandbagToFile(nova4, ARTICLES_FILE); */
                    break;
                case 5:
                    Tshirt nova5 = Tshirt.createTshirt();
                    printTshirtToFile(nova5, ARTICLES_FILE);
                    printTshirtToFileHistory(userEmail, nova5, SELL_FILE);
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
