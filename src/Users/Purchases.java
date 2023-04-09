package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Purchases {
    public static void printUserSales(String email) {
        String SELL_FILE = "sellhistory.txt";
        String BUY_FILE = "buyhistory.txt";

        try {
            Scanner scanner = new Scanner(new File(SELL_FILE));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(":");

                if (values[0].equals(email)) {
                    String itemType = values[3].substring(0, 2);

                    switch (itemType) {
                        case "TN":
                            System.out.println("T-Shirt");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item ID: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n"
                            + "Size: " + values[9] + ", Pattern: " + values[10] + "\n");
                            break;
                        case "SN":
                            System.out.println("Shoe");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item ID: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n" +
                                    "Size: " + values[9] + ", Has shoelaces: " + values[10] + ", Color: " + values[11] + ", Collection Year: " + values[12] + "\n");
                            break;
                        case "HN":
                            System.out.println("Handbag");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item ID: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n" +
                                    "Size: " + values[9] + ", Collection Year: " + values[10] + ", Material: " + values[11] + "\n");
                            break;
                        default:
                            System.out.println("Unknown item type: " + itemType);
                            break;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + SELL_FILE);
        }
    }

    public static void printAllSalesExceptUser(String userEmail) {
        String STOCK_DIRECTORY = "stock/";
        File directory = new File(STOCK_DIRECTORY);
        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Directory " + STOCK_DIRECTORY + " does not exist.");
            return;
        }

        for (File file : files) {
            if (file.getName().endsWith(".txt") && !file.getName().startsWith(userEmail)) {
                try {
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] values = line.split(":");

                        String itemType = values[2].substring(0, 2);

                        switch (itemType) {
                            case "TN":
                                System.out.println("T-Shirt");
                                System.out.println("Description: " + values[0] + ", Brand: " + values[1] + ", Item ID: " + values[2] + ", Transport Company: " + values[3]
                                        + ", Price: " + values[4] + ", Discount: " + values[5] + ", Previous Owners: " + values[6] + ", Stock: " + values[7] + "\n"
                                        + "Size: " + values[8] + ", Pattern: " + values[9] + "\n");
                                break;
                            case "SN":
                                System.out.println("Shoe");
                                System.out.println("Description: " + values[0] + ", Brand: " + values[1] + ", Item ID: " + values[2] + ", Transport Company: " + values[3]
                                        + ", Price: " + values[4] + ", Discount: " + values[5] + ", Previous Owners: " + values[6] + ", Stock: " + values[7] + "\n" +
                                        "Size: " + values[8] + ", Has shoelaces: " + values[9] + ", Color: " + values[10] + ", Collection Year: " + values[11] + "\n");
                                break;
                            case "HN":
                                System.out.println("Handbag");
                                System.out.println("Description: " + values[0] + ", Brand: " + values[1] + ", Item ID: " + values[2] + ", Transport Company: " + values[3]
                                        + ", Price: " + values[4] + ", Discount: " + values[5] + ", Previous Owners: " + values[6] + ", Stock: " + values[7] + "\n" +
                                        "Size: " + values[8] + ", Collection Year: " + values[9] + ", Material: " + values[10] + "\n");
                                break;
                            default:
                                System.out.println("Unknown item type: " + itemType);
                                break;
                        }
                    }

                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
            }
        }
    }
}
