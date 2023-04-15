package Users;

import Items.Artigo;
import Items.Mala;
import Items.Sapatilha;
import Items.Tshirt;
import Time.Data;
import Transportation.Encomenda;

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
import static Users.BuyOrSell.buyOrSellArticle;
import static Users.Purchases.*;

public class Buy {
    public static void buyArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Encomenda encomenda = new Encomenda(new ArrayList<>(),0,0.0,"Em transito", Data.tempo,""); //verificar a transportadora
        String BUY_FILE = "buyhistory.txt";
        ArrayList<Artigo> cart = new ArrayList<>();
        ArrayList<Artigo> stock = getAllSales();
        String itemId;

        while(running) {
            System.out.println("Select if you want to:\n1) See the stock\n2) Add items to your shopping cart\n3) Remove items from shopping cart\n4)Display shopping cart\n5)Buy shopping cart\n\n0) exit:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Artigo artigo : stock) {
                    System.out.println(artigo.toString());
                }
                    break;
                case 2:
                    System.out.println("Select the item you want to add to your shopping cart typing the id: ");
                    itemId = scanner.next();
                    addItemToCart(itemId, cart);

                    break;
                case 3:
                    System.out.println("Select the item you want to remove to your shopping cart typing the id: ");
                    break;
                case 4:

                    break;
                case 5:
                    itemId = scanner.next();
                    removeItemFromUserStock(userEmail, itemId);
                    break;
                case 0:
                    buyOrSellArticle(userEmail);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
