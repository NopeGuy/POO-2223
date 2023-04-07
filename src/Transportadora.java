public class Transportadora {
    private String nome;
    private double preço_pequena;//1 artigo
    private double preço_media;//2 a 5 artigos
    private double preço_grande;// 6 ou mais

    //o fator dos impostos da vintage está definido no arranque
    //PrecoExpedicao = (V alorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9

    public Transportadora(String nome, double preço_pequena, double preço_media, double preço_grande) {
        this.nome = nome;
        this.preço_pequena = preço_pequena;
        this.preço_media = preço_media;
        this.preço_grande = preço_grande;
    }
    
}
