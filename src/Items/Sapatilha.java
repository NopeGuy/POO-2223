package Items;

import java.time.LocalDate;

public class Sapatilha extends Artigo{
    private int tamanho;
    private boolean atacadores;
    private String cor;
    private int ano_colecao;



    //construtores
    public Sapatilha(){
        super();
        this.tamanho = -1;
        this.atacadores = false;
        this.cor = "";
        this.ano_colecao = 0;
    }

    public Sapatilha(Sapatilha sapatilha){
        super(sapatilha);
        this.tamanho = sapatilha.getTamanho();
        this.atacadores = sapatilha.isAtacadores();
        this.cor = sapatilha.getCor();
        this.ano_colecao = sapatilha.getAno_colecao();
    }

    public Sapatilha(String descricao, String marca, String item_id,String transportadora, double preco, double desconto, int num_donos,int stock, int tamanho, boolean atacadores, String cor, int ano_colecao) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos,stock);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.ano_colecao = ano_colecao;
    }

    //getters
    public int getTamanho() {
        return tamanho;
    }

    public boolean isAtacadores() {
        return atacadores;
    }

    public String getCor() {
        return cor;
    }

    public int getAno_colecao() {
        return ano_colecao;
    }

    //setters

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno_colecao(int ano_colecao) {
        this.ano_colecao = ano_colecao;
    }


    //clone

    public Sapatilha clone(){
        return new Sapatilha(this);
    }
    //toString

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Sapatilha: ").append(super.toString()).append("Tamanho: ").append(this.tamanho).append("Atacadores: ").append(this.atacadores).append("Cor: ").append(this.cor).append("Ano da colecao: ").append(this.ano_colecao);
        return sb.toString();
    }

    //equals

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        Sapatilha s = (Sapatilha) o;
        return (super.equals(s) && this.tamanho == s.getTamanho() && this.atacadores == s.isAtacadores() && this.cor.equals(s.getCor()) && this.ano_colecao == s.getAno_colecao());
    }

    //metodos desconto

    public boolean validaDescontoSapatilha(){
        if((LocalDate.now().getYear()-this.getAno_colecao()<=0)) return false;
        return this.tamanho > 45;
    }

    public void calculaDescontoSapatilha(){
        if(this.validaDescontoSapatilha()){
        this.setDesconto((LocalDate.now().getYear()-this.getAno_colecao()));
        }
        else this.setDesconto(0);
        this.setPreco(this.getPreco()*(1-this.getDesconto()/100));
    }

    //há desconto se forem de um ano diferente do atual, ou tamanho > 45
    //preço sapatilha usada: precoBase − (precoBase/numeroDonos ∗ estadoU tilizacao)



}
