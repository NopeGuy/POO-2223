import Items.*;
import Time.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Encomenda {
    private Collection<Artigo> colecao;
    private int dimensao;
    private double preco_final;
    private String estado;
    private final LocalDate data_criacao;
    private String transportadora;

    // Construtor
    public Encomenda(Collection<Artigo> colecao, int dimensao, double preco_final, String estado, LocalDate data_criacao,String transportadora) {
        this.colecao = new ArrayList<>(colecao);
        this.dimensao = dimensao;
        this.preco_final = preco_final;
        this.estado = estado;
        this.data_criacao = data_criacao;
        this.transportadora=transportadora;
    }
    // Construtor de cópia
    public Encomenda(Encomenda encomenda) {
        this(encomenda.colecao, encomenda.dimensao, encomenda.preco_final, encomenda.estado, encomenda.data_criacao,encomenda.transportadora);
    }

    // Construtor vazio
    public Encomenda() {
        this(new ArrayList<>(), 0, 0.0, "", LocalDate.now(),"");
    }


    // Métodos de acesso
    public Collection<Artigo> getColecao() {
        return new ArrayList<>(colecao);
    }

    public int getDimensao() {
        return dimensao;
    }

    public double getPreco_final() {
        return preco_final;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public String getTransportadora(){return transportadora;}

    // Métodos de modificação

    public void calcularPrecoFinal() {
        double total = 0.0;
        for (Artigo artigo : colecao) {
            if(artigo instanceof Mala) ((Mala) artigo).calculaPreco();
            if(artigo instanceof MalaPremium) ((MalaPremium) artigo).calculaPreco();
            if(artigo instanceof Sapatilha) ((Sapatilha) artigo).calculaPreco();
            if(artigo instanceof SapatilhaPremium) ((SapatilhaPremium) artigo).calculaPreco();
            if(artigo instanceof Tshirt) ((Tshirt) artigo).calculaPreco();
            total += artigo.getPreco();
        }
        this.preco_final = total;
    }
    public void adicionarArtigo(Artigo artigo) {
        if(artigo.getStock()>0){
        if(colecao.add(artigo.clone())){
            this.dimensao++;
            this.preco_final += artigo.getPreco();
            artigo.setStock(artigo.getStock()-1);
        }
    }
    }

    public void removerArtigo(Artigo artigo) {
        if(colecao.remove(artigo)){
            this.dimensao--;
            this.preco_final -= artigo.getPreco();
            artigo.setStock(artigo.getStock()+1);
        }
    }



    public boolean validaDevolucao(){
        return !this.data_criacao.isBefore(Data.tempo.minusDays(2));
    }

    // Métodos sobrescritos
    @Override
    public Encomenda clone() {
        try {
            Encomenda clone = (Encomenda) super.clone();
            clone.colecao = new ArrayList<>(colecao);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Encomenda)) return false;
        Encomenda e = (Encomenda) o;
        return Objects.equals(colecao, e.colecao) &&
                this.dimensao==e.dimensao &&
                Double.compare(preco_final, e.preco_final) == 0 &&
                Objects.equals(estado, e.estado) &&
                Objects.equals(data_criacao, e.data_criacao);
    }
    @Override
    public String toString() {
        return "Encomenda{" +
                "colecao=" + colecao +
                ", dimensao='" + dimensao + '\'' +
                ", preco_final=" + preco_final +
                ", estado='" + estado + '\'' +
                ", data_criacao=" + data_criacao +
                '}';
    }

}

//criar encomenda
//adicionar artigos
//calcular preço final = set preço final
//devolver