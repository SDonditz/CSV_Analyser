import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        CSVAnalyser analyser = new CSVAnalyser();

        System.out.println(analyser.readCSV("CSV/test.csv"));
        System.out.println(analyser.readCSV("CSV/test2.csv"));
        System.out.println(analyser.readCSV("CSV/test3.csv"));
    }
}