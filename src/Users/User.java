package Users;

import Items.Artigo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {
    private String name;
    private String userId;
    private String email;
    private String morada;
    private String nif;
    private List<Artigo> vendeu;
    private List<Artigo> comprou;


    public User() {
        this.name = "";
        this.userId = "";
        this.email = "";
        this.morada = "";
        this.nif = "";
        this.vendeu = new ArrayList<>();
        this.comprou = new ArrayList<>();
    }

    public User(String name, String userId, String email, String morada, String nif, List<Artigo> vendeu, List<Artigo> comprou) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.morada = morada;
        this.nif = nif;
        this.vendeu = vendeu;
        this.comprou = comprou;
    }


    public static ArrayList<User> readUsers(String USERS_FILE) {
        ArrayList<User> usersList = new ArrayList<>();
        try {
            File file = new File(USERS_FILE);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] userData = data.split(",");
                String name = userData[0];
                String userId = userData[1];
                String email = userData[2];
                String morada = userData[3];
                String nif = userData[4];
                //String vendas = userData[5];
                //String compras = userData[6];
                //mudar para ler depois a lista de artigos atraves da string
                ArrayList<Artigo> vendeu = new ArrayList<>();
                ArrayList<Artigo> comprou = new ArrayList<>();
                //passar String para lista de artigos
                User user = new User(name, userId, email, morada, nif, vendeu, comprou);
                usersList.add(user);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return usersList;
    }

    public static void writeUser(String USERS_FILE, User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            writer.println(user.toString());
            System.out.println("User saved to file: " + user.toString());
        } catch (IOException e) {
            System.out.println("Failed to save user to file.");
        }
    }

    public static String createUser(String USERS_FILE) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter NIF:");
        String morada = scanner.nextLine();
        System.out.println("Enter Address:");
        String nif = scanner.nextLine();
        ArrayList<Artigo> vendeu = new ArrayList<>();
        String userId = User.generateUserId(name);
        ArrayList<Artigo> comprou = new ArrayList<>();
        User user = new User(name, userId, email, morada, nif, vendeu, comprou);
        writeUser(USERS_FILE, user);
        scanner.close();
        return userId;
    }


    public static boolean loginUser(String userEmail, List<User> userList) {

        User user = findUserByEmail(userList, userEmail);

        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    private static User findUserByEmail(List<? extends User> userList, String userEmail) {
        for (User user : userList) {
            if (user.getEmail().equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    public static String generateUserId(String name) {
        return "U" + name + (int) (Math.random() * 1000);
    }

    /*
    public static ArrayList<Artigo> convertToArrayList(String artigosVendidos) {
        ArrayList<Artigo> listaArtigos = new ArrayList<>();
        String[] arrayArtigos = artigosVendidos.split(";");
        for (String artigo : arrayArtigos) {
            String[] dadosArtigo = artigo.split(",");
            String descricao = dadosArtigo[0].trim();
            String marca = dadosArtigo[1].trim();
            String item_id = dadosArtigo[2].trim();
            String transportadora = dadosArtigo[3].trim();
            double preco = Double.parseDouble(dadosArtigo[4].trim());
            double desconto = Double.parseDouble(dadosArtigo[5].trim());
            int num_donos = Integer.parseInt(dadosArtigo[6].trim());
            int stock = Integer.parseInt(dadosArtigo[7].trim());
            Artigo novoArtigo = new Artigo(descricao, marca, item_id, transportadora, preco, desconto, num_donos, stock);
            listaArtigos.add(novoArtigo);
        }
        return listaArtigos;
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    public User clone() {
        try {
            User clone = (User) super.clone();
            clone.vendeu = new ArrayList<>(vendeu);
            clone.comprou = new ArrayList<>(comprou);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        User u = (User) o;
        return Objects.equals(nif, u.nif) &&
                Objects.equals(userId, u.userId) &&
                Objects.equals(email, u.email) &&
                Objects.equals(morada, u.morada) &&
                Objects.equals(vendeu, u.vendeu) &&
                Objects.equals(comprou, u.comprou);
    }

    @Override
    public String toString() {
        return name + "," + userId + "," + email + "," + morada + "," + nif + "," + vendeu + "," + comprou;}
    }



