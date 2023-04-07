import Items.Artigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String user_id; //gerado automaticamente
    private String email; //usado para login
    private String morada;
    private int num_fiscal;
    private List<Artigo> vendeu;
    private List<Artigo> comprou;

    public User(String email, String morada, int num_fiscal) {
        this.user_id = generateUserId();
        this.email = email;
        this.morada = morada;
        this.num_fiscal = num_fiscal;
        this.vendeu = new ArrayList<>();
        this.comprou = new ArrayList<>();
    }

    //Lembrete tipos primitos não precisam de clone mesmo numa estratégia de composição

    private String generateUserId() {
        // lógica para gerar o user_id
        return "user_" + Math.round(Math.random() * 1000);
    }

    //Gets e sets
    //vendeu e comprou ainda por fazer, têm de ser pensados depois
    //set de id tem de ser automatico por isso está por fazer ainda,
    public String getEmail() {
        return email;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getMorada() {
        return morada;
    }

    public int getNum_fiscal() {
        return num_fiscal;
    }

    public void setNum_fiscal(int num_fiscal) {
        this.num_fiscal = num_fiscal;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMorada(String morada) {
        this.morada = morada;
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
        return num_fiscal == u.num_fiscal &&
                Objects.equals(user_id, u.user_id) &&
                Objects.equals(email, u.email) &&
                Objects.equals(morada, u.morada) &&
                Objects.equals(vendeu, u.vendeu) &&
                Objects.equals(comprou, u.comprou);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", morada='" + morada + '\'' +
                ", num_fiscal=" + num_fiscal +
                ", vendeu=" + vendeu +
                ", comprou=" + comprou +
                '}';
    }
}
