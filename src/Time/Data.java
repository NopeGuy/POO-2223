package Time;

import java.time.LocalDate;

public class Data {
    public static LocalDate tempo;

    public void addDays(int x){
        tempo=tempo.plusDays(x);
    }
    
    public boolean validaData(LocalDate x){ //se validaData==true retira-se do ficheiro "Em transito"
        return tempo.isBefore(x);
    }
}
