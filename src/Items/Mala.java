package Items;

import java.time.LocalDate;

public class Mala extends Artigo {
    private String dimensao; //pode ser pequena média ou grande
    private int ano_colecao;
    private String material;

    //desconto é maior se a mala for maior

    //construtores
    public Mala(){
        super();
        this.dimensao = "";
        this.ano_colecao = 0;
        this.material = "";
    }

    public Mala(Mala malas){
        super(malas);
        this.dimensao = malas.getDimensao();
        this.ano_colecao = malas.getAno_colecao();
        this.material = malas.getMaterial();
    }

    public Mala(String descricao, String marca, String item_id, String transportadora, double preco, double desconto, int num_donos,int stock, String dimensao, int ano_colecao, String material) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos, stock);
        this.dimensao = dimensao;
        this.ano_colecao = ano_colecao;
        this.material = material;
    }

    //getters
    public String getDimensao() {
        return dimensao;
    }

    public int getAno_colecao() {
        return ano_colecao;
    }

    public String getMaterial() {
        return material;
    }
    //setters

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public void setAno_colecao(int ano_colecao) {
        this.ano_colecao = ano_colecao;
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
        sb.append("Mala: ").append(super.toString()).append("Dimensao: ").append(this.dimensao).append("Ano da colecao: ").append(this.ano_colecao).append("Material: ").append(this.material);
        return sb.toString();
    }

    //equals

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Mala)) return false;
        Mala m = (Mala) o;
        return dimensao.equals(m.dimensao) &&
                ano_colecao == m.ano_colecao &&
                material.equals(m.material);
    }

    //Desconto descontoMala dá set ao desconto, calculaPrecoMala calcula o novo preço

    public void descontoMala(){
        double dDim,dAno,dMat;
        if(this.getNum_donos()>0) {
            dAno=(LocalDate.now().getYear()-this.getAno_colecao());
            if (this.getDimensao().equals("pequena")) dDim=20;
            else if (this.getDimensao().equals("media")) dDim=10;
            else dDim=0;
            if(this.getMaterial().equals("couro falso")) dMat=20;
            else if(this.getMaterial().equals("couro cigano")) dMat=10;
            else dMat=0;
            this.setDesconto(dAno*2+dDim+dMat);
        }
    }
    //calcula o preço final (apenas dependente do tamanho da mala)
    public void calculaPrecoMala(){
        this.descontoMala();
        if(this.getDesconto()>=100) this.setPreco(0);
        else this.setPreco(this.getPreco()*(1-this.getDesconto()/100));
    }
}
