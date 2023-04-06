public class Artigo {
    private String descricao;
    private String marca;
    private String item_id;
    private double preco;
    private double desconto;


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

}
