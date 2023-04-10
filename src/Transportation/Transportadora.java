package Transportation;

import java.util.Objects;

public class Transportadora {
    private String nome;
    private double preço_pequena;//1 artigo
    private double preço_media;//2 a 5 artigos
    private double preço_grande;// 6 ou mais

    //o fator dos impostos da vintage está definido no arranque
    //PrecoExpedicao = (V alorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9

    public Transportadora() {
        this.nome = "";
        this.preço_pequena = 0;
        this.preço_media = 0;
        this.preço_grande = 0;
    }

    public Transportadora(String nome, double preço_pequena, double preço_media, double preço_grande) {
        this.nome = nome;
        this.preço_pequena = preço_pequena;
        this.preço_media = preço_media;
        this.preço_grande = preço_grande;
    }

    public Transportadora(Transportadora t){
        this.nome = t.getNome();
        this.preço_pequena = t.getPreço_pequena();
        this.preço_media = t.getPreço_media();
        this.preço_grande = t.getPreço_grande();
    }

    public void setPreço_media(double preço_media) {
        this.preço_media = preço_media;
    }

    public void setPreço_grande(double preço_grande) {
        this.preço_grande = preço_grande;
    }

    public void setPreço_pequena(double preço_pequena) {
        this.preço_pequena = preço_pequena;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreço_grande() {
        return preço_grande;
    }

    public double getPreço_pequena() {
        return preço_pequena;
    }

    public double getPreço_media() {
        return preço_media;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Transportadora(this);
    }

    @Override
    public boolean equals(Object p){
        if (p == this) return true;
        if (p == null || this.getClass() != p.getClass()) return false;
        Transportadora t = (Transportadora) p;
        return this.nome.equals(t.nome) && this.preço_pequena == t.preço_pequena && this.preço_media == t.preço_media && this.preço_grande == t.preço_grande;
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                "nome='" + nome + '\'' +
                ", preço_pequena=" + preço_pequena +
                ", preço_media=" + preço_media +
                ", preço_grande=" + preço_grande +
                '}';
    }
}
