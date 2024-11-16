import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Pdf6 {
    public static void zad1() throws IOException {
        System.out.println("Zad1");
        int[] threeValues = liczZnakiiSlowa("src/file1.txt");
        System.out.println("Liczba znakow: " + threeValues[0] + " Liczba bialych znakow: " + threeValues[1] + " Liczba slow: " + threeValues[2]);
    }

    private static int wordCount(String text) { //z pdf5
        int wordCount = 0;
        boolean wordEnded = false;
        for (int i = 0; i < text.length(); i++) {
            if (wordCount == 0 && !Character.isWhitespace(text.charAt(i))) wordCount++;
            if (wordCount > 0 && !wordEnded && Character.isWhitespace(text.charAt(i))) {
                wordEnded = true;
            }
            if (wordCount > 0 && wordEnded && !Character.isWhitespace(text.charAt(i))) {
                wordEnded = false;
                wordCount++;
            }
        }
        return wordCount;
    }

    private static int[] liczZnakiiSlowa(String filePath) throws IOException {
        int charCount = 0, whiteCharCount = 0, wordCount = 0;
        int[] threeValues = new int[3];
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(filePath)));
            char[] charArr = text.toCharArray();
            charCount = charArr.length;
            for (char c : charArr) {
                if (c == ' ' || c == '\n' || c == '\t') whiteCharCount++;
            }
            wordCount = wordCount(text);
        } catch (IOException e) {
            System.out.println("Wystapil blad czytania pliku!");
        }
        threeValues[0] = charCount;
        threeValues[1] = whiteCharCount;
        threeValues[2] = wordCount;
        return threeValues;
    }

    public static void zad2() throws IOException {
        System.out.println("zad2");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj slowo(bez spacji na poczatku i koncu): ");
        String word = " " + sc.nextLine() + " ";
        System.out.print("Podaj nazwe pliku zapisu(plik bedzie zapisany w src)(nie dopisuj .txt): ");
        String fileName = "src/" + sc.nextLine() + ".txt";
        szukaj("src/file1.txt", fileName, word);

    }

    private static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo) throws IOException {
        StringBuilder newText = new StringBuilder();
        int lineCount = 1;
        try {
            File ogFile = new File(nazwaPlikWe);
            Scanner sc = new Scanner(ogFile);
            while (sc.hasNextLine()) {
                String line = " " + sc.nextLine();
                if (line.contains(slowo)) newText.append(lineCount).append(":").append(line).append("\n");
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Blad w czytaniu pliku");
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nazwaPlikWy);
            fileWriter.write(String.valueOf(newText));
        } catch (Exception e) {
            System.out.println("Blad w zapisywaniu pliku");
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }

    public static void zad3() throws IOException {
        System.out.println("zad3");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku, bazowo nums(bez .txt):");
        String fileName = "src/" + sc.nextLine() + ".txt";
        sumujIZapisz(fileName);
    }

    private static void sumujIZapisz(String nazwaPliku) throws IOException {
        int sum = 0;
        StringBuilder text = new StringBuilder();
        try {
            File file = new File(nazwaPliku);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int num = Integer.parseInt(line);
                sum += num;
                text.append(line += "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nieprawidlowa nazwa pliku!");
            return;
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nazwaPliku);
            text.append(sum);
            fileWriter.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }

    public static void zad4() throws IOException {
        System.out.println("zad4");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku (w src, bez .txt) (file1 bazowo): ");
        String fileName = sc.nextLine();
        System.out.print("Podaj przesuniecie: ");
        int n = sc.nextInt();
        szyfruj(fileName, n);
        System.out.print("Podaj nazwe pliku do ryzszyfrowania (w src, bez .txt) (nazwę_file1 bazowo): ");
        String fileName2 = sc.nextLine();
        fileName2 = sc.nextLine();
        System.out.print("Podaj przesuniecie: ");
        int n2 = sc.nextInt();
        deszyfruj(fileName2, n2);

    }

    private static void szyfruj(String nazwaWe, int przesun) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        try {
            File file = new File("src/" + nazwaWe + ".txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                textBuilder.append(line += "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nieprawidlowa nazwa pliku!");
            return;
        }
        String text = String.valueOf(textBuilder);
        textBuilder = new StringBuilder();
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < text.length(); i++) {
            charList.add(text.charAt(i));
        }
        char[] alphabetArray = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
        for (int i = 0; i < charList.size(); i++) {
            boolean isChar = false;
            int alphIndex = 0;
            for (int j = 0; j < alphabetArray.length; j++) {
                if (alphabetArray[j] == charList.get(i) || Character.toUpperCase(alphabetArray[j]) == charList.get(i)) {
                    isChar = true;
                    alphIndex = j;
                    break;
                }
            }
            if (isChar) {
                int newIndex = (alphIndex + przesun) % alphabetArray.length;
                if (newIndex < 0) newIndex += alphabetArray.length;
                if (Character.isUpperCase(charList.get(i)))
                    charList.set(i, Character.toUpperCase(alphabetArray[newIndex]));
                else charList.set(i, alphabetArray[newIndex]);
            }
            textBuilder.append(charList.get(i));
        }
        text = String.valueOf(textBuilder);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/nazwę_" + nazwaWe + ".txt");
            fileWriter.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }

    private static void deszyfruj(String nazwaWe, int przesun) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        try {
            File file = new File("src/" + nazwaWe + ".txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                textBuilder.append(line += "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nieprawidlowa nazwa pliku!");
            return;
        }
        String text = String.valueOf(textBuilder);
        char[] alphabetArray = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
        textBuilder = new StringBuilder();
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < text.length(); i++) {
            charList.add(text.charAt(i));
        }
        for (int i = 0; i < charList.size(); i++) {
            int alphIndex = 0;
            boolean isChar = false;
            for (int j = 0; j < alphabetArray.length; j++) {
                if (alphabetArray[j] == charList.get(i) || Character.toUpperCase(alphabetArray[j]) == charList.get(i)) {
                    alphIndex = j;
                    isChar = true;
                }
            }
            if (isChar) {
                int newIndex = alphIndex - przesun;
                while (newIndex < 0) {
                    newIndex += alphabetArray.length;
                }
                if (Character.isUpperCase(charList.get(i)))
                    charList.set(i, Character.toUpperCase(alphabetArray[newIndex]));
                else charList.set(i, alphabetArray[newIndex]);
            }
            textBuilder.append(charList.get(i));
        }
        text = String.valueOf(textBuilder);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/rozszyfr_" + nazwaWe + ".txt");
            fileWriter.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }

    public static void zad5() {
        System.out.println("zad5");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwę pliku z danymi osob(w src, bez .txt) (bazowo daneOsobowe): ");
        String fileName = "src/" + sc.nextLine() + ".txt";
        emerytura(fileName);
    }

    private static void emerytura(String nazwaPliku) {
        StringBuilder textBuilderMen = new StringBuilder();
        StringBuilder textBuilderWomen = new StringBuilder();
        try {
            File file = new File(nazwaPliku);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] personData = line.split(" ");
                int age = 65;
                try {
                    age = Integer.parseInt(personData[3]);
                } catch (Exception e) {
                    System.out.println("Blad w przetwarzaniu wieku");
                }
                if (Objects.equals(personData[2], "M")) {
                    int yearsLeft = 65 - age;
                    if (yearsLeft < 0) yearsLeft = 0;
                    textBuilderMen.append(personData[1]).append(" ").append(personData[0]).append(" ").append(yearsLeft).append("\n");
                } else {
                    int yearsLeft = 60 - age;
                    if (yearsLeft < 0) yearsLeft = 0;
                    textBuilderWomen.append(personData[1]).append(" ").append(personData[0]).append(" ").append(yearsLeft).append("\n");
                }
            }
            String textMen = textBuilderMen.toString();
            String textWomen = textBuilderWomen.toString();
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("src/mezczyzni.txt");
                fileWriter.write(textMen);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (fileWriter != null) fileWriter.close();
            }
            fileWriter = null;
            try {
                fileWriter = new FileWriter("src/kobiety.txt");
                fileWriter.write(textWomen);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (fileWriter != null) fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Nieprawidlowa nazwa pliku!");
            return;
        }
    }

    public static void zad6() throws IOException {
        System.out.println("zad6");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwę pliku z danymi (w src, bez .txt) (bazowo daneBMI): ");
        String fileName = "src/" + sc.nextLine() + ".txt";
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body>\n<table>\n");
        try{
            File file = new File(fileName);
            Scanner fileSc = new Scanner(file);
            while (fileSc.hasNextLine()){
                String line = fileSc.nextLine();
                String[] lineArr = line.split(" ");
                htmlBuilder.append("<tr>");
                for (String cell : lineArr){
                    htmlBuilder.append("<td>").append(cell).append("</td>");
                }
                htmlBuilder.append("</tr>\n");
            }
            htmlBuilder.append("</table>\n</body></html>");

        } catch(Exception e) { System.out.println("Blad w odczytywaniu pliku"); return;}
        String htmlCode = htmlBuilder.toString();
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("src/bmiTable.html");
            fileWriter.write(htmlCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }
    public static void zad7() throws IOException {
        System.out.println("zad7");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwę pliku z tekstem(w src, bez .txt) (bazowo pg76 lub file1): ");
        String fileName = "src/" + sc.nextLine() + ".txt";
        StringBuilder chartBuilder = new StringBuilder();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[] alphabetValues = new int[alphabet.length];
        try{
            File file = new File(fileName);
            Scanner fileSc = new Scanner(file);
            while (fileSc.hasNextLine()){
                String line = fileSc.nextLine();
                for(char c : line.toCharArray()){
                    for(int i = 0; i < alphabet.length; i++){
                        if(c == alphabet[i]){
                            alphabetValues[i]++;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Nieprawidlowa nazwa pliku!");
            return;
        }
        int max = 1;
        for(int count:alphabetValues) if(max < count) max = count;
        int valuePerStar = max / 50;
        System.out.println(valuePerStar);
        for(int i = 0; i < alphabet.length; i++){
            chartBuilder.append(alphabet[i]).append(" ");
            int numOfStars = alphabetValues[i] / valuePerStar;
            System.out.println(alphabet[i] + " " +  numOfStars);
            if(alphabetValues[i] == max) numOfStars = 50;
            for(int j = 0; j <= 50; j++){
                if(j < numOfStars) chartBuilder.append("*");
                else chartBuilder.append(" ");
            }
            chartBuilder.append(" ").append(alphabetValues[i]).append("\n");
        }
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("src/alphabetChart.txt");
            fileWriter.write(chartBuilder.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) fileWriter.close();
        }
    }
}
