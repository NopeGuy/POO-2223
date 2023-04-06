import java.util.List;

public class User {
    private String user_id; //gerado automaticamente
    private String email; //usado para login
    private String morada;
    private int num_fiscal;
    private List<Artigo> vendeu;
    private List<Artigo> comprou;


    //Lembrete tipos primitos não precisam de clone mesmo numa estratégia de composição


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
}
