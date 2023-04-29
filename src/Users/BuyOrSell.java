package Users;

import Time.Data;
import Transportation.Encomenda;
import Transportation.Transportadora;

import java.util.Scanner;

import static Time.Data.tempo;

public class BuyOrSell {
    public static void buyOrSellArticle(String userEmail) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while(running) {
            System.out.println("\"Welcome to the shop, today is "+ tempo + ",\nWhat are you here for?: \n1) Buy \n2) Sell \n3) Buy history \n4) Sell history \n5) Check and Return packages \n6) Check Admin Functionality\n\n0) exit ");
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
                    Purchases.printUserSales(userEmail, "buyhistory.txt");
                    break;
                case 4:
                    Purchases.printUserSales(userEmail, "sellhistory.txt");
                    break;
                case 5:
                    Pack.packagesMenu(userEmail);
                    break;
                case 6:
                    System.out.println("Admin functions are:\n80) Skip 'x' days\n81) Change package carriers\n82) Store statistics\n\nPlease enter one of those options to continue with admin functions");
                    break;
                case 80:
                    Data.addDays();
                    System.out.println("Date advanced to " + tempo + "\n");
                    Encomenda.atualizarEstadoEncomendas();
                    break;
                case 81:
                    //mudaTransportes;
                    Transportadora.transporteMenu(userEmail);
                    break;
                case 82:
                    //estatisticasMenu;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}