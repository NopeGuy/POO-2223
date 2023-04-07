package Items;

public class SapatilhaPremium extends Sapatilha{
    //sapatilhas premium têm autores reconhecidos que aumentam o preço com o passar do anos

    public SapatilhaPremium(){
        super();
    }

    public SapatilhaPremium(SapatilhaPremium sapatilhaPremium){
        super(sapatilhaPremium);
    }

    public SapatilhaPremium(String descricao, String marca, String item_id,String transportadora, double preco, double desconto, int num_donos,int stock, int tamanho, boolean atacadores, String cor, int ano_coleção) {
        super(descricao, marca, item_id,transportadora, preco, desconto, num_donos, stock, tamanho, atacadores, cor, ano_coleção);
    }

    




}
