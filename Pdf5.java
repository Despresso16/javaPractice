import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pdf5 {
    public static void zad1() {
        System.out.println("Zad1");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int num = sc.nextInt();
        System.out.println("Iteracyjnie: ");
        int fact = 1;
        for (int i = num; i > 0; i--) {
            fact *= i;
        }
        System.out.println(fact);
        System.out.println("Rekurencyjnie: ");
        System.out.println(FactorialRec(num));
    }

    private static int FactorialRec(int num) {
        if (num < 0)
            return -1;
        else if (num == 0)
            return 1;
        else {
            return (num * FactorialRec(num - 1));
        }
    }

    public static void zad2() {
        System.out.println("Zad2");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int num = sc.nextInt();
        System.out.print("Iteracyjnie: ");
        int fibNumMinus2 = 0, fibNumMinus1 = 1, fibNum = 1;
        for (int i = 2; i <= num; i++) {
            fibNum = fibNumMinus1 + fibNumMinus2;
            fibNumMinus2 = fibNumMinus1;
            fibNumMinus1 = fibNum;
        }
        System.out.println(fibNum);
        System.out.println("Rekurencyjnie: " + FibonacciRec((num)));
    }

    private static int FibonacciRec(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n > 1) {
            return FibonacciRec(n - 2) + FibonacciRec(n - 1);
        }
        return 0;

    }

    public static void zad3() {
        System.out.println("Zad3");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj char: ");
        char character = sc.nextLine().charAt(0);
        System.out.println(strpos(text, character));

    }

    private static int strpos(String text, char z) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == z) {
                return i;
            }
        }
        return -1;
    }

    public static void zad4() {
        System.out.println("Zad4");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.println(flipCase(text));
    }

    private static String flipCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) result += Character.toLowerCase(c);
            else if (Character.isLowerCase(c)) result += Character.toUpperCase(c);
            else result += c;
        }
        return result;
    }

    public static void zad5() {
        System.out.println("Zad5");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj prefix: ");
        String prefix = sc.nextLine();
        if (startsWith(text, prefix)) System.out.println("Text zawiera prefix");
        else System.out.println("Text nie zawiera prefixu");
    }

    private static boolean startsWith(String text, String prefix) {
        if (prefix.length() > text.length()) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (text.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void zad6() {
        System.out.println("Zad6");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.println(strToInt(text));
    }

    private static int strToInt(String str) {
        if (str == null || str.isEmpty()) return 0;
        int result = 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        boolean foundDigits = false;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                foundDigits = true;
                result = result * 10 + (c - '0');
            } else if (Character.toLowerCase(c) == 'e') {
                i++;
                if (i < str.length() && Character.isDigit(str.charAt(i))) {
                    int powValue = 0;
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        powValue = powValue * 10 + (str.charAt(i) - '0');
                        i++;
                    }
                    return result * sign * (int) Math.pow(10, powValue);
                }
                break;
            } else break;
            i++;
        }
        if (!foundDigits) return 0;
        return result * sign;
    }

    public static void zad7() {
        System.out.println("Zad7");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text (gdzie): ");
        String text1 = sc.nextLine();
        System.out.print("Podaj text (co): ");
        String text2 = sc.nextLine();
        System.out.println(strFind(text1, text2));
    }

    private static int strFind(String textWhere, String textIn) {
        if (textIn.isEmpty()) return 0;
        for (int i = 0; i <= textWhere.length() - textIn.length(); i++) {
            int j;
            for (j = 0; j < textIn.length(); j++) {
                if (textWhere.charAt(i + j) != textIn.charAt(j)) break;
            }
            if (j == textIn.length()) return i;
        }
        return -1;
    }

    public static void zad8() {
        System.out.println("Zad8");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.println("Wordcount: " + wordCount(text));
    }

    private static int wordCount(String text) {
        int wordCount = 0;
        boolean wordEnded = false;
        for (int i = 0; i < text.length(); i++) {
            if (wordCount == 0 && !Character.isWhitespace(text.charAt(i))) wordCount++;
            if (wordCount > 0 && !wordEnded && Character.isWhitespace(text.charAt(i))) wordEnded = true;
            if (wordCount > 0 && wordEnded && !Character.isWhitespace(text.charAt(i))) {
                wordEnded = false;
                wordCount++;
            }
        }
        return wordCount;
    }

    public static void zad9() {
        System.out.println("Zad9");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        String[] wordArray = podzielNaSlowa(text);
        System.out.println("Słowa osobno w każdej linii:");
        for (String word : wordArray) {
            System.out.println(word);
        }
    }

    private static String[] podzielNaSlowa(String text) {
        List<String> wordList = new ArrayList<>();
        String word = "";
        boolean readingWord = false;
        for (int i = 0; i < text.length(); i++) {
            if (!readingWord && !Character.isWhitespace(text.charAt(i))) readingWord = true;
            if (readingWord && !Character.isWhitespace(text.charAt(i))) word += text.charAt(i);
            if (readingWord && (Character.isWhitespace(text.charAt(i)) || i == text.length() - 1)) {
                readingWord = false;
                wordList.add(word);
                word = "";
            }
        }
        String[] wordArray = new String[wordList.size()];
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordList.get(i);
        }
        return wordArray;
    }

    public static void zad10() {
        System.out.println("Zad10");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text (gdzie): ");
        String text1 = sc.nextLine();
        System.out.print("Podaj text (co): ");
        String text2 = sc.nextLine();
        System.out.println(strFindAndCount(text1, text2));
    }

    private static int strFindAndCount(String textWhere, String textIn) {
        int textInCount = 0;
        int index = 0;

        while (index != -1) {
            index = strFind(textWhere, textIn);
            if (index != -1) {
                textInCount++;
                index += textIn.length();
                textWhere = textWhere.substring(index);
            }
        }
        return textInCount;
    }

    public static void zad11() {
        System.out.println("Zad11");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj start: ");
        int start = sc.nextInt();
        System.out.print("Podaj ile: ");
        int howMuch = sc.nextInt();
        System.out.println(strcut(text, start, howMuch));
    }

    private static String strcut(String str, int start, int ile) {
        if (str == null || start < 0 || ile < 0 || start >= str.length()) {
            return str;
        }
        int end = start + ile;
        String before = str.substring(0, start);
        String after = str.substring(end);
        return before + after;
    }
    
    public static void zad13(){
        System.out.println("Zad13");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj dlugosc tablicy: ");
        int len = sc.nextInt();
        int[] order = new int[len];
        for(int i = 0; i < order.length; i++){
            System.out.print("Podaj liczbe: ");
            order[i] = sc.nextInt();
        }
        System.out.println(poprzestawiaj(text, order));
    }
    private static String poprzestawiaj(String text, int[] order) {
        if (text == null || order == null) return null;
        char[] wynik = new char[text.length()];
        for (int i = 0; i < order.length; i++) {
            wynik[i] = text.charAt(order[i]);
        }
        return new String(wynik);
    }
    public static void zad14(){
        System.out.println("Zad14");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj t1: ");
        String text1 = sc.nextLine();
        System.out.print("Podaj t2: ");
        String text2 = sc.nextLine();
        if(czyAnagram(text1, text2)) System.out.println("t2 jest anagramem t1");
        else System.out.println("t2 nie jest anagramem t1");
    }
    public static boolean czyAnagram(String t1, String t2) {
        String filtered1 = t1.toLowerCase();
        String filtered2 = t2.toLowerCase();
        filtered1 = filtered1.replaceAll("\\s+", "");
        filtered2 = filtered2.replaceAll("\\s+", "");
        if (filtered1.length() != filtered2.length()) return false;
        char[] charArrayT1 = filtered1.toCharArray();
        char[] charArrayT2 = filtered2.toCharArray();
        Arrays.sort(charArrayT1);
        Arrays.sort(charArrayT2);
        return Arrays.equals(charArrayT1, charArrayT2);
    }
    public static void zad15() {
        System.out.println("Zad15");
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj hex: ");
        String hex = sc.nextLine();
        int[] rgb = hexToRgb(hex);
        for(int i = 0; i < rgb.length; i++){
            System.out.print(rgb[i] + ", ");
        }
    }
    public static int[] hexToRgb(String hex) {
        Pattern pattern = Pattern.compile("^#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hex);
        if (matcher.matches()) {
            return new int[] {
                    Integer.parseInt(matcher.group(1), 16),
                    Integer.parseInt(matcher.group(2), 16),
                    Integer.parseInt(matcher.group(3), 16)
            };
        }
        return null;
    }
}
