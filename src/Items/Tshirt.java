package Items;



public class Tshirt extends Artigo{
    private String tamanho;
    private String padrao; //pode ser lisa, riscas ou palmeiras

    //Lisas nunca têm desconto, as restantes têm 50% de desconto se forem usadas

    //construtores
    public Tshirt(){
        super();
        this.tamanho = "";
        this.padrao = "";
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt);
        this.tamanho = tshirt.getTamanho();
        this.padrao = tshirt.getpadrao();
    }

    public Tshirt(String descricao, String marca, String item_id,String transportadora, double preco, double desconto, int num_donos,int stock, String tamanho, String padrao) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos, stock);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    //getters

    public String getTamanho() {
        return tamanho;
    }

    public String getpadrao() {
        return padrao;
    }

    //setters

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setpadrao(String padrao) {
        this.padrao = padrao;
    }

    //clone

    public Tshirt clone(){
        return new Tshirt(this);
    }
    //tostring

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tshirt{");
        sb.append("tamanho=").append(this.tamanho);
        sb.append(", padrao=").append(this.padrao);
        sb.append(", ").append(super.toString());
        sb.append("}");
        return sb.toString();
    }

    //equasls

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Tshirt tshirt = (Tshirt) o;
        return (super.equals(tshirt) && this.tamanho.equals(tshirt.getTamanho()) && this.padrao.equals(tshirt.getpadrao()));
    }

    //metodo desconto

    public void calculaPrecoTshirt() {
        if (this.getNum_donos() > 0) {
            if (this.padrao.equals("lisa")) this.setDesconto(0);
            else this.setDesconto(50);
            this.setPreco(this.getPreco() * (1 - this.getDesconto() / 100));
        }
    }

}
