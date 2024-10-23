import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public static void zad2() throws FileNotFoundException {
        System.out.println("zad2");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj slowo: ");
        String word = sc.nextLine();
        System.out.print("Podaj nazwe pliku zapisu(plik bedzie zapisany w src): ");
        String fileName = sc.nextLine();
        szukaj("src/file1.txt", fileName, word);

    }
    private static void szukaj(String nazwaPlikWe, String nazwaPlikWy,String slowo) throws FileNotFoundException {
        BufferedReader fileReader = null;
        String ogText = "", newText = "";
        try {
            Scanner sc = new Scanner(new File(nazwaPlikWe));
            while (sc.hasNext()){
                
            }

        } catch (IOException e) {
            System.out.println("Blad w czytaniu pliku");
        }


    }
}
