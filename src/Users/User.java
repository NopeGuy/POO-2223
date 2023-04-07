package Users;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User {
    private String name;
    private String userId;
    private String email;
    private String nif;


    public User() {
        this.name = "";
        this.userId = "";
        this.email = "";
        this.nif = "";
    }

    public User(String name, String userId, String email, String nif){
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.nif = nif;
    }



    public static void writeUser(String USERS_FILE, User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            writer.println(user.toString());
            System.out.println("User saved to file: " + user.toString());
        } catch (IOException e) {
            System.out.println("Failed to save user to file.");
        }
    }

    public static String generateUserId(String name) {
        return "U" + name + (int) (Math.random() * 1000);
    }

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
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}

