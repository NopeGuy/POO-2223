package Items;

import Time.Data;

import java.time.LocalDate;

public class MalaPremium extends Mala{
    //malas premium, o preço sobre x% por ano
    
    public MalaPremium(){
        super();
    }

    public MalaPremium(MalaPremium malaPremium){
        super(malaPremium);
    }

    public MalaPremium(String descricao, String marca, String item_id, String transportadora, double preco, double desconto, int num_donos, int stock, String dimensao, int ano_colecao, String material) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos, stock, dimensao, ano_colecao, material);
    }


    public void calculaDesconto(){
        double dAno;
        dAno=(Data.tempo.getYear()-this.getAno_colecao());
        this.setDesconto(dAno*5);
    }

    public void calculaPreco(){
        this.calculaDesconto();
        this.setPreco(this.getPreco()*(1+this.getDesconto())/100+this.taxaSatisfacao());
    }

}
