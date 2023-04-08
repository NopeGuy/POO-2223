package Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Seller {
    private String name;
    private String sellerId;
    private String email;
    private String address;
    private String nif;


    public Seller() {
        this.name = "";
        this.sellerId = "";
        this.email = "";
        this.nif = "";
    }

    public Seller(String name, String sellerId, String email, String nif){
        this.name = name;
        this.sellerId = sellerId;
        this.email = email;
        this.nif = nif;
    }


    public static ArrayList<Seller> readSellers(String filename) {
        ArrayList<Seller> sellers = new ArrayList<Seller>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] sellerInfo = line.split(",");
                String name = sellerInfo[0];
                String id = sellerInfo[1];
                String email = sellerInfo[2];
                String nif = sellerInfo[3];
                Seller seller = new Seller(name, id, email, nif);
                sellers.add(seller);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return sellers;
    }

    public static void writeSeller(String SELLERS_FILE, Seller seller) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SELLERS_FILE, true))) {
            writer.println(seller.toString());
            System.out.println("Seller saved to file: " + seller.toString());
        } catch (IOException e) {
            System.out.println("Failed to save seller to file.");
        }
    }

    public static String generateSellerId(String name) {
        return "S" + name + (int) (Math.random() * 1000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String userId) {
        this.sellerId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return name + "," + sellerId + "," + email + "," + nif;
    }

}

