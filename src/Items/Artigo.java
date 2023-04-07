package Items;
import java.util.Objects;


public class Artigo {
    private String descricao;
    private String marca;
    private String item_id;
    private String transportadora;
    private double preco;
    private double desconto;
    private int num_donos;




    public void setNum_donos(int num_donos) {
        this.num_donos = num_donos;
    }
    public int getNum_donos() {
        return num_donos;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public double getDesconto() {
        return desconto;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getItem_id() {
        return item_id;
    }

    public double getPreco() {
        return preco;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public Artigo(){
        this.descricao = "";
        this.marca = "";
        this.item_id = "";
        this.transportadora = "";
        this.preco = 0;
        this.desconto = 0;
        this.num_donos = 0;
    }

    public Artigo(Artigo artigo){
        this.descricao = artigo.getDescricao();
        this.marca = artigo.getMarca();
        this.transportadora = artigo.getTransportadora();
        this.item_id = artigo.getItem_id();
        this.preco = artigo.getPreco();
        this.desconto = artigo.getDesconto();
        this.num_donos = artigo.getNum_donos();
    }

    public Artigo(String descricao, String marca, String item_id,String transportadora, double preco, double desconto, int num_donos){
        this.descricao = descricao;
        this.marca = marca;
        this.transportadora = transportadora;
        this.item_id = item_id;
        this.preco = preco;
        this.desconto = desconto;
        this.num_donos = num_donos;
    }

    public Artigo clone(){
        return new Artigo(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Artigo)) return false;
        Artigo a = (Artigo) o;
        return num_donos == a.num_donos &&
                Objects.equals(descricao, a.descricao) &&
                Objects.equals(marca, a.marca) &&
                Objects.equals(item_id, a.item_id) &&
                Objects.equals(preco, a.preco) &&
                Objects.equals(desconto, a.desconto) &&
                Objects.equals(transportadora, a.transportadora);
    }

    public String toString(){
        return "Artigo{" +
                "descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", item_id='" + item_id + '\'' +
                ", transportadora='" + transportadora + '\'' +
                ", preco=" + preco +
                ", desconto=" + desconto +
                ", num_donos=" + num_donos +
                '}';
    }



}
