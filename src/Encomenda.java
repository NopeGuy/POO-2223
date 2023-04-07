import Items.Artigo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Encomenda {
    private Collection<Artigo> colecao;
    private String dimensao;
    private double preco_final;
    private String estado;
    private LocalDate data_criacao;

    // Construtor
    public Encomenda(Collection<Artigo> colecao, String dimensao, double preco_final, String estado, LocalDate data_criacao) {
        this.colecao = new ArrayList<>(colecao);
        this.dimensao = dimensao;
        this.preco_final = preco_final;
        this.estado = estado;
        this.data_criacao = data_criacao;
    }
    // Construtor de cópia
    public Encomenda(Encomenda encomenda) {
        this(encomenda.colecao, encomenda.dimensao, encomenda.preco_final, encomenda.estado, encomenda.data_criacao);
    }

    // Construtor vazio
    public Encomenda() {
        this(new ArrayList<>(), "", 0.0, "", LocalDate.now());
    }


    // Métodos de acesso
    public Collection<Artigo> getColecao() {
        return new ArrayList<>(colecao);
    }

    public String getDimensao() {
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

    // Métodos de modificação
    public void adicionarArtigo(Artigo artigo) {
        colecao.add(artigo);
    }

    public void removerArtigo(Artigo artigo) {
        colecao.remove(artigo);
    }

    public void calcularPrecoFinal() {
        double total = 0.0;
        for (Artigo artigo : colecao) {
            total += artigo.getPreco();
        }
        this.preco_final = total;
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
                Objects.equals(dimensao, e.dimensao) &&
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