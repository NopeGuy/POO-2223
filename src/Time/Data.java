package Time;

import Transportation.Encomenda;
import java.util.Collection;
import java.time.LocalDate;
import java.util.Scanner;

public class Data {
    public static LocalDate tempo;

    public static void addDays(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter the number of days to skip: ");
        int days = scanner.nextInt();
        tempo=tempo.plusDays(days);

        //falta inserir aqui as verificações das encomendas em transito
    }

    //ideia de como fazer verificação de transito, atualmente não faz nada
    public static void checkEncomendas(Collection<Encomenda> encomendas, LocalDate date) {
        for (Encomenda encomenda : encomendas) {
            if (encomenda.getData_criacao().isBefore(date.minusDays(2))) {
                System.out.println("Encomenda " + encomenda.getEncomendaId() + " is more than 2 days old.");
                encomenda.setEstado("Entregue.");
            }
        }
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
        scanner.nextLine();
        int[] valoresData = new int[3];
        int i=0;
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                valoresData[i]=scanner.nextInt();
                i++;
            }
            scanner.next();
        }
        LocalDate novo = LocalDate.of(valoresData[2],valoresData[1],valoresData[0]);
        tempo=novo;
    }
}
