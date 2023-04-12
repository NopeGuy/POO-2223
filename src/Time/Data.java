package Time;

import java.time.LocalDate;
import java.util.Scanner;

public class Data {
    public static LocalDate tempo;

    public static void addDays(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the number of days to skip: ");
        int days = scanner.nextInt();
        tempo=tempo.plusDays(days);
        System.out.println(tempo);
        //falta inserir aqui as verificações das encomendas em transito
    }
    
    public boolean validaData(LocalDate x){ //se validaData==true retira-se do ficheiro "Em transito"
        return tempo.isBefore(x);
    }

    public void setData(LocalDate x){
        tempo=x;
    }

    public static void startTempo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the initial date (dd-mm-yyyy): ");
        String bo = scanner.next();
        String[] bos = bo.split("-");
        int dia = Integer.parseInt(bos[0]);
        int mes = Integer.parseInt(bos[1]);
        int ano = Integer.parseInt(bos[2]);
        LocalDate novo = LocalDate.of(ano,mes,dia);
        tempo=novo;
    }
}
