package Items;

public class Mala extends Artigo {
    private String dimensao; //pode ser pequena média ou grande
    private int ano_coleção;
    private String material;

    //desconto é maior se a mala for maior

    //construtores
    public Mala(){
        super();
        this.dimensao = "";
        this.ano_coleção = -1;
        this.material = "";
    }

    public Mala(Mala malas){
        super(malas);
        this.dimensao = malas.getDimensao();
        this.ano_coleção = malas.getAno_coleção();
        this.material = malas.getMaterial();
    }

    public Mala(String descricao, String marca, String item_id, String transportadora, double preco, double desconto, int num_donos,int stock, String dimensao, int ano_coleção, String material) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos, stock);
        this.dimensao = dimensao;
        this.ano_coleção = ano_coleção;
        this.material = material;
    }

    //getters
    public String getDimensao() {
        return dimensao;
    }

    public int getAno_coleção() {
        return ano_coleção;
    }

    public String getMaterial() {
        return material;
    }
    //setters

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public void setAno_coleção(int ano_coleção) {
        this.ano_coleção = ano_coleção;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //clone

    public Mala clone(){
        return new Mala(this);
    }

    //tostring

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Mala: ").append(super.toString()).append("Dimensao: ").append(this.dimensao).append("Ano da coleção: ").append(this.ano_coleção).append("Material: ").append(this.material);
        return sb.toString();
    }

    //equals

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Mala)) return false;
        Mala m = (Mala) o;
        return dimensao.equals(m.dimensao) &&
                ano_coleção == m.ano_coleção &&
                material.equals(m.material);
    }
}
