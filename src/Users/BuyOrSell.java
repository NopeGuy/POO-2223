package Users;

import Time.Data;

import java.util.Scanner;

public class BuyOrSell {
    public static void buyOrSellArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while(running) {
            System.out.println("\"Welcome to the shop, here to: \n1) Buy \n2) Sell \n3) Buy history \n4) Sell history \n5) Advance date ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Buy.buyArticle(userEmail);
                    break;
                case 2:
                    Sell.sellArticle(userEmail);
                    break;
                case 3:
                    //do later
                    break;
                case 4:
                    Purchases.printUserSales(userEmail, "sellhistory.txt");
                    break;
                case 5:
                    Data.addDays();
                    System.out.println("Date advanced to " + Data.tempo + "\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}