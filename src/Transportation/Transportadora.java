package Transportation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transportadora {
    private String nome;
    private double preço_pequena;//1 artigo
    private double preço_media;//2 a 5 artigos
    private double preço_grande;// 6 ou mais
    private int tamanho;

    //o fator dos impostos da vintage está definido no arranque
    //PrecoExpedicao = (V alorBase ∗ margemlucrotransportadora ∗ (1 + Imposto)) ∗ 0.9

    public Transportadora() {
        this.nome = "";
        this.preço_pequena = 0;
        this.preço_media = 0;
        this.preço_grande = 0;
        this.tamanho = 0;
    }

    public Transportadora(String nome, double preço_pequena, double preço_media, double preço_grande) {
        this.nome = nome;
        this.preço_pequena = preço_pequena;
        this.preço_media = preço_media;
        this.preço_grande = preço_grande;
        this.tamanho = 0;

    }

    public Transportadora(Transportadora t){
        this.nome = t.getNome();
        this.preço_pequena = t.getPreço_pequena();
        this.preço_media = t.getPreço_media();
        this.preço_grande = t.getPreço_grande();
        this.tamanho = t.getTamanho();
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

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
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
    public Object clone() throws CloneNotSupportedException {
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

    public List<Transportadora> readDatabaseTransportadora() {
        // Criar lista para guardas os objetos do tipo transportadora
        List<Transportadora> transportadoras = new ArrayList<>();
        try {
            // Abrir o database.txt
            File file = new File("src/Transportation/transportadoras.txt");
            Scanner scanner = new Scanner(file);

            // Read the file line by line
            while (scanner.hasNextLine()) {
                // Read the name of the transportadora
                String data = scanner.nextLine().trim();

                // Read the prices for each size
                String[] transportationData = data.split(",");
                String nome = transportationData[0];
                double precoPequena = Double.parseDouble(transportationData[1]);
                double precoMedia = Double.parseDouble(transportationData[2]);
                double precoGrande = Double.parseDouble(transportationData[3]);

                // Create a new Transportadora object and add it to the list
                Transportadora transportadora = new Transportadora(nome, precoPequena, precoMedia, precoGrande);
                transportadoras.add(transportadora);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


        return transportadoras;
    }

    public void printTransportadoras(List<Transportadora> transportadoras){
        for (Transportadora transportadora : transportadoras) {
            System.out.println(transportadora);
        }
    }

    public double calculaTaxa(Transportadora t){

        if (t.tamanho == 1){
            return t.preço_pequena;
        }
        else if (t.tamanho >= 2 && t.tamanho <= 5){
            return t.preço_media;
        }
        else if (t.tamanho >= 6){
            return t.preço_grande;
        }
        else{
            return 0.0;
        }
    }
}
