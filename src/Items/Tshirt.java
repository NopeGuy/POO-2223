package Items;

public class Tshirt extends Artigo{
    private String tamanho;
    private String padrão; //pode ser lisa, riscas ou palmeiras

    //Lisas nunca têm desconto, as restantes têm 50% de desconto se forem usadas

    //construtores
    public Tshirt(){
        super();
        this.tamanho = "";
        this.padrão = "";
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt);
        this.tamanho = tshirt.getTamanho();
        this.padrão = tshirt.getPadrão();
    }

    public Tshirt(String descricao, String marca, String item_id,String transportadora, double preco, double desconto, int num_donos, String tamanho, String padrão) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos);
        this.tamanho = tamanho;
        this.padrão = padrão;
    }

    //getters

    public String getTamanho() {
        return tamanho;
    }

    public String getPadrão() {
        return padrão;
    }

    //setters

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrão(String padrão) {
        this.padrão = padrão;
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
        sb.append(", padrão=").append(this.padrão);
        sb.append(", ").append(super.toString());
        sb.append("}");
        return sb.toString();
    }

    //equasls

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Tshirt tshirt = (Tshirt) o;
        return (super.equals(tshirt) && this.tamanho.equals(tshirt.getTamanho()) && this.padrão.equals(tshirt.getPadrão()));
    }




}
