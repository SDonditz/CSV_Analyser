import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVAnalyser {
    private List<List<String>> compilData;

    public CSVAnalyser() {
        this.compilData = new ArrayList<>();
    }

    public List<List<String>> readCSV(String fileName) throws IOException {
        this.compilData = new ArrayList<>();
        String line;
        int counter = 0;
        try {
            //FileReader pour lire le fichier qui se trouve à l'adresse en paramètre
            FileReader fileReader = new FileReader(fileName);

            //BufferReader avec Filereader en paramètre pour lire ligne par ligne dans le fichier
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Instancition d'une String ligne et lecture du fichier tant qu'elle est différente de null
            while((line = bufferedReader.readLine()) != null) {
                List<String> buffTab = new ArrayList<>();
                buffTab.add(line);
                this.compilData.add(buffTab);
            }
            //Fermeture du BufferReader
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Fichier inexistant");
        }

        Utils.addSymbolNewLine(this.compilData, ",");
        Utils.addDataShelter(this.compilData, "'", ",");
        Utils.removeDoubleQuotes(this.compilData, "'", ",");

        return this.compilData;
    }

}
