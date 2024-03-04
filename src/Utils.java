import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void addSymbolNewLine(List<List<String>> csvInArray, String splitter) {
        for(int i = 0; i < csvInArray.size() ; i++) {
            List<String> list = new ArrayList<>(csvInArray.get(i));
            String temp = list.get(0);
            String[] tempTab = temp.split(splitter);
            for (int j = 0; j < tempTab.length; j++) {
                //Traitement des exceptions
                if (tempTab[j].length() > 1) {
                    if (tempTab[j].substring(0, 1).equals("\"")) {
                        if (!tempTab[j].substring(tempTab[j].length() - 1, tempTab[j].length()).equals("\"") ||
                                (tempTab[j].substring(tempTab[j].length() - 1, tempTab[j].length()).equals("\"") &&
                                        tempTab[j].substring(tempTab[j].length() - 2, tempTab[j].length() - 1).equals("\""))) {
                            List<String> ListToMerge = csvInArray.get(i + 1);
                            String tempPlusOne = temp + "\\n " + ListToMerge.get(0);
                            list.set(0, tempPlusOne);
                            csvInArray.set(i, list);
                            csvInArray.remove(i + 1);
                            i--;
                        }
                    }
                }
            }
        }
    }

    public static void addDataShelter(List<List<String>> csvInArray, String shelter, String splitter) {
        for(int i = 0; i < csvInArray.size(); i++) {
            List<String> list = new ArrayList<>();
            String temp = csvInArray.get(i).get(0);
            String[] tempTab = temp.split(splitter);
            StringBuilder text = new StringBuilder();
            for(int j = 0; j < tempTab.length; j++) {
                if(j != tempTab.length - 1) {
                    text.append(shelter).append(tempTab[j]).append(shelter).append(splitter);
                } else {
                    text.append(shelter).append(tempTab[j]).append(shelter);
                }
            }
            list.add(text.toString());
            csvInArray.set(i, list);
        }
    }

    public static void removeDoubleQuotes(List<List<String>> csvInArray, String shelter, String splitter) {
        for(int i = 0; i < csvInArray.size(); i++) {
            List<String> list = new ArrayList<>();
            String temp = csvInArray.get(i).get(0);
            String[] tempTab = temp.split(splitter);
            for(String text: tempTab) {
                text = text.replace("\"\"", "\"");
                text = text.replace(shelter + "\"", shelter);
                text = text.replace("\"" + shelter, shelter);
                list.add(text);
            }
            csvInArray.set(i, list);
        }
    }

}
