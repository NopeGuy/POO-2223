import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Purchases {
    public static void printUserSales(String email) {
        String BUY_FILE = "sellhistory.txt";

        try {
            Scanner scanner = new Scanner(new File(BUY_FILE));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(":");

                if (values[0].equals(email)) {
                    String itemType = values[3].substring(0, 2);

                    switch (itemType) {
                        case "TN":
                            System.out.println("T-Shirt");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item Id: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n"
                            + "Size: " + values[9] + ", Pattern: " + values[10]);
                            break;
                        case "SN":
                            System.out.println("Shoe");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item Id: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n" +
                                    "Size: " + values[9] + ", Has shoelaces: " + values[10] + ", Color: " + values[11] + ", Collection Year: " + values[12]);
                            break;
                        case "HN":
                            System.out.println("Handbag");
                            System.out.println("Description: " + values[1] + ", Brand: " + values[2] + ", Item Id: " + values[3] + ", Transport Company: " + values[4]
                                    + ", Price: " + values[5] + ", Discount: " + values[6] + ", Previous Owners: " + values[7] + ", Stock: " + values[8] + "\n" +
                                    "Size: " + values[9] + ", Collection Year: " + values[10] + ", Material: " + values[11]);
                            break;
                        default:
                            System.out.println("Unknown item type: " + itemType);
                            break;
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + BUY_FILE);
        }
    }
}
