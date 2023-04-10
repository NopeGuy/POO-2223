package Transportation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TransportadoraParser {

    public List<Transportadora> readDatabaseTransportadora() {
        // Criar lista para guardas os objetos do tipo transportadora
        List<Transportadora> transportadoras = new ArrayList<>();
        try {
            // Abrir o database.txt
            File file = new File("POOTP2223/src/Transportation/transportadoras.txt");
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
    public static void main(String[] args) {
        List<Transportadora> t = new ArrayList<>();

        TransportadoraParser parser = new TransportadoraParser();
        t = parser.readDatabaseTransportadora();

        parser.printTransportadoras(t);
    }

}


