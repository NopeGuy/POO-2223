package Users;

import java.util.Scanner;
import static Users.BuyOrSell.buyOrSellArticle;

public class Queries {
    public static void statisticsMenu(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String BUY_FILE = "Files/buyhistory.txt";
        String SELL_FILE = "Files/sellhistory.txt";
        String ORDERS_FILE = "Files/orders.txt";

        while (running) {
            System.out.println(
                    "Select one of the following: \n 1) Seller who billed the most \n 2) Carrier which has the highest billing volume \n 3) Orders issued by a seller \n 4) Ranking of the largest buyers/sellers in the system \n 5) Vintage Profits \n\n  0) Exit:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:
                
                    break;
                case 3:
                
                    break;
                case 4:
                
                    break;
                case 5:
                
                    break;
                case 0:
                    buyOrSellArticle(userEmail);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
