import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Pdf6 {
//    private static void writeFile(String filePath) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        FileWriter fileWriter = null;
//        StringBuilder text = new StringBuilder();
//        String line = "";
//        System.out.println("Wpisz tekst (liniowo) (napisz \"end\" zeby zakonczyc");
//        while(!Objects.equals(line, "end")){
//            line = sc.nextLine();
//            if(!Objects.equals(line, "end")) text.append(line).append("\n");
//        }
//        try{
//            fileWriter = new FileWriter(filePath);
//            fileWriter.write(text.toString());
//        } catch (IOException e) {
//            System.out.println("Nastapil blad w zapisywaniu pliku!");
//        } finally {
//            if(fileWriter != null) fileWriter.close();
//        }
//    }
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
            if (wordCount > 0 && !wordEnded && Character.isWhitespace(text.charAt(i))){
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
        try{
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
        return  threeValues;
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

    private static void szukaj(String nazwaPlikWe, String nazwaPlikWy,String slowo) throws IOException {
        StringBuilder newText = new StringBuilder();
        int lineCount = 1;
        try {
            File ogFile = new File(nazwaPlikWe);
            Scanner sc = new Scanner(ogFile);
            while(sc.hasNextLine()){
                String line = " " + sc.nextLine();
                if(line.contains(slowo)) newText.append(lineCount).append(":").append(line).append("\n");
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Blad w czytaniu pliku");
        }
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(nazwaPlikWy);
            fileWriter.write(String.valueOf(newText));
        } catch (Exception e){
            System.out.println("Blad w zapisywaniu pliku");
        } finally {
            if(fileWriter != null) fileWriter.close();
        }
    }
    public static void zad3() throws IOException {
        System.out.println("zad3");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku, bazowo nums(bez .txt):");
        String fileName ="src/" + sc.nextLine() + ".txt";
        sumujIZapisz(fileName);
    }
    private static void sumujIZapisz(String nazwaPliku) throws IOException {
        int sum = 0;
        StringBuilder text = new StringBuilder();
        try{
            File file = new File(nazwaPliku);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
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
        try{
            fileWriter = new FileWriter(nazwaPliku);
            text.append(sum);
            fileWriter.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileWriter != null) fileWriter.close();
        }
    }
    public static void zad4() throws IOException {
        System.out.println("zad4");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj nazwe pliku (w src, bez .txt) (file1 bazowo)");
        String fileName = sc.nextLine();
        System.out.println("Podaj przesuniecie");
        int n = sc.nextInt();
        szyfruj(fileName, n);

    }
    private static void szyfruj(String nazwaWe, int przesun) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        try{
            File file = new File("src/" + nazwaWe + ".txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
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
        for(int i = 0; i < text.length(); i++){
            charList.add(text.charAt(i));
        }
        char[] alphabetArray = "aąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż".toCharArray();
        for(int i = 0; i < charList.size(); i++) {
            boolean isChar = false;
            for(int j = 0; j < alphabetArray.length; j++){
                if(alphabetArray[j] == charList.get(i)) isChar = true;
            }
            if(isChar){
                int newIndex = (i + przesun) % alphabetArray.length;
                if(newIndex < 0) newIndex += alphabetArray.length;
                //nie dzialaja uppercase to fix
                if(Character.isUpperCase(charList.get(i))) charList.set(i, Character.toUpperCase(alphabetArray[newIndex]));
                else charList.set(i, alphabetArray[newIndex]);
            }
            textBuilder.append(charList.get(i));
        }
        text = String.valueOf(textBuilder);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("src/nązwe_" + nazwaWe + ".txt");
            fileWriter.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileWriter != null) fileWriter.close();
        }
    }
    private static void deszyfruj(String nazwaWe, int przesun){

    }
}
