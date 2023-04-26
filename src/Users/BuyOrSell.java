package Users;

import Time.Data;
import Transportation.Encomenda;

import java.util.Scanner;

public class BuyOrSell {
    public static void buyOrSellArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Encomenda e = new Encomenda(); //só para importar o método ataulizar estado

        while(running) {
            System.out.println("\"Welcome to the shop, here to: \n1) Buy \n2) Sell \n3) Buy history \n4) Sell history \n5) Check and Return packages \n6) Advance date\n0 - exit ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
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

                    break;
                case 6:
                    Data.addDays();
                    System.out.println("Date advanced to " + Data.tempo + "\n");
                    Purchases.atualizaPrecoStock(userEmail);
                    Encomenda.atualizarEstadoEncomendas();
                    //print updates to encomenda
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}