package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Users.BuyOrSell.buyOrSellArticle;

public class Queries {
    public static void statisticsMenu(String userEmail) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

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
                    sellerWithHighestBilling(SELL_FILE);
                    break;
                case 2:
                    carrierWithHighestBilling(BUY_FILE);
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



    public static void sellerWithHighestBilling(String sellFile) {
        try {
            Map<String, Double> sellerToBilling = new HashMap<>();

            File file = new File(sellFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                String seller = parts[0];
                double price = Double.parseDouble(parts[5]);
                String itemID = parts[3];
                boolean itemSold = false;

                // check if itemID is present in buyhistory
                File buyHistoryFile = new File("Files/buyhistory.txt");
                Scanner buyHistoryScanner = new Scanner(buyHistoryFile);
                while (buyHistoryScanner.hasNextLine()) {
                    String buyHistoryLine = buyHistoryScanner.nextLine();
                    String[] buyHistoryParts = buyHistoryLine.split(":");
                    String buyHistoryItemID = buyHistoryParts[3];
                    if (buyHistoryItemID.equals(itemID)) {
                        itemSold = true;
                        break;
                    }
                }
                buyHistoryScanner.close();

                // add price to seller's billing if item was sold
                if (itemSold) {
                    if (sellerToBilling.containsKey(seller)) {
                        double totalBilling = sellerToBilling.get(seller) + price;
                        sellerToBilling.put(seller, totalBilling);
                    } else {
                        sellerToBilling.put(seller, price);
                    }
                }
            }
            scanner.close();

            double highestBilling = 0;
            String sellerWithHighestBilling = "";

            for (String seller : sellerToBilling.keySet()) {
                double billing = sellerToBilling.get(seller);
                if (billing > highestBilling) {
                    highestBilling = billing;
                    sellerWithHighestBilling = seller;
                }
            }

            System.out.println("\nSeller with highest billing: " + sellerWithHighestBilling + " (€" + String.format("%.2f", highestBilling) + ")\n");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    
public static void carrierWithHighestBilling(String buyFile) {
    try {
        Map<String, Integer> carrierToCount = new HashMap<>();

        File file = new File(buyFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            String carrier = parts[4];

            // add carrier to count
            if (carrierToCount.containsKey(carrier)) {
                int count = carrierToCount.get(carrier) + 1;
                carrierToCount.put(carrier, count);
            } else {
                carrierToCount.put(carrier, 1);
            }
        }
        scanner.close();

        int highestCount = 0;
        String carrierWithHighestCount = "";

        for (String carrier : carrierToCount.keySet()) {
            int count = carrierToCount.get(carrier);
            if (count > highestCount) {
                highestCount = count;
                carrierWithHighestCount = carrier;
            }
        }

        System.out.println("\nCarrier with highest billing: " + carrierWithHighestCount + "\n");

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    }
}

}
