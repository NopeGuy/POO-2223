package Items;

import Time.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

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
    public String toString2(){
        return super.toString2() + ":" + this.tamanho + ":" + this.atacadores + ":" + this.cor + ":" + this.ano_colecao;
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
        if((Data.tempo.getYear()-this.getAno_colecao()<=0)) return false;
        return this.getTamanho() > 45;
    }

    public void calculaDesconto(){
        if(this.validaDescontoSapatilha()){
        this.setDesconto((Data.tempo.getYear()-this.getAno_colecao()));
        }
        else this.setDesconto(0);

    }
    public void calculaPreco(){
        calculaDesconto();
        this.setPreco(this.getPreco()*(1-this.getDesconto()/100)+this.taxaSatisfacao());
    }

    //há desconto se forem de um ano diferente do atual, ou tamanho > 45
    //preço sapatilha usada: precoBase − (precoBase/numeroDonos ∗ estadoU tilizacao)

    public static Sapatilha createShoe() {
        Scanner scanner = new Scanner(System.in);

        String itemId = "SN" + (int) (Math.random() * 100000);
        System.out.print("Item ID will be: " + itemId + "\n");

        System.out.print("Enter shoe description: ");
        String descricao = scanner.nextLine().trim();

        System.out.print("Enter shoe brand: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Enter transport company name: 1)GLS, 2)CTT, 3)DPD: ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        String transportadora = "";
        switch (choice) {
            case 1:
                transportadora = "GLS";
                break;
            case 2:
                transportadora = "CTT";
                break;
            case 3:
                transportadora = "UPS";
                break;
            default:
                System.out.println("Invalid dimension. Setting to GLS.");
                transportadora = "GLS";
                break;
        }

        System.out.print("Enter price: ");
        double preco = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter discount: ");
        double desconto = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter number of previous owners: ");
        int numDonos = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter stock: ");
        int stock = Integer.parseInt(scanner.nextLine().trim());
        while(stock == 0){
            System.out.println("Stock can't be 0");
            System.out.print("Enter stock: ");
            stock = Integer.parseInt(scanner.nextLine().trim());
        }

        System.out.print("Enter shoe size: ");
        int tamanho = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter shoe laces 1)Has 2)Doesn't has them: ");
        boolean atacadoresBool = true;
        int atacadores = Integer.parseInt(scanner.nextLine().trim());
        if(atacadores == 2){ atacadoresBool = false;}

        System.out.print("Enter shoe color(lower case only): ");
        String cor = scanner.nextLine().trim();

        System.out.print("Enter year of collection: ");
        int ano_colecao = Integer.parseInt(scanner.nextLine().trim());



        return new Sapatilha(descricao, marca, itemId, transportadora, preco, desconto, numDonos, stock, tamanho, atacadoresBool, cor, ano_colecao);
    }

    public static void printShoeToFile(Sapatilha sapatilha, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(sapatilha.toString2() + ",");
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to print Shoe to file.");
        }
    }
    public static void printShoetoFileHistory(String userEmail, Sapatilha sapatilha, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(userEmail + ":" + sapatilha.toString2() + ",");
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to print Shoe to file history.");
        }
    }
}
