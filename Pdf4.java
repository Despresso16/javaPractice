import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pdf4 {

    public static void zad1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        char character = text.charAt(text.length()-1);
        int charCount = 0;
        for(char c: text.toCharArray()) {
            if(c == character) charCount++;
        }
        System.out.println(charCount);
    }
    public static void zad2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        String text2 = "";
        for(int i = text.length()-1; i >= 0; i--) {
            text2 += text.charAt(i);
        }
        System.out.println(text2);

    }
    public static void zad3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        String text2 = "";
        for(int i = text.length()-1; i >= 0; i--) {
            text2 += text.charAt(i);
        }
        if(text.equals(text2)) System.out.println("Palindrom"); else System.out.println("Non-Palindrom");

    }
    public static void zad4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        int suma = 0;
        for(int i = text.length()-1; i >= 0; i--) {
            try {
                suma += Integer.parseInt(String.valueOf(text.charAt(i)));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(suma);
    }
    public static void zad5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj dzialanie: ");
        String text = sc.nextLine();
        int openingCount = 0, closingCount = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '(') openingCount++;
            else if (text.charAt(i) == ')') closingCount++;
            else continue;
            if(closingCount > openingCount){
                System.out.println("Blad");
                break;
            }
        }
        if(openingCount == closingCount) System.out.println("Prawidlowe dzialania");
        else System.out.println("Nieprawidlowe dzialania");
    }
    public static void zad6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj text: ");
        String text = sc.nextLine();
        System.out.print("Podaj n: ");
        List<Character> charList = new ArrayList<Character>();
        for(int i = 0; i < text.length(); i++){
            charList.add(text.charAt(i));
        }
        char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int n = sc.nextInt();
        for(int i = 0; i < charList.size(); i++) {
            boolean isChar = false;
            for(int j = 0; j < alphabetArray.length; j++){
                if(alphabetArray[j] == charList.get(i)) isChar = true;
            }
            if(isChar){
                int newIndex = (i + n) % alphabetArray.length;
                if(newIndex < 0) newIndex += alphabetArray.length;
                if(Character.isUpperCase(charList.get(i))) charList.set(i, Character.toUpperCase(alphabetArray[newIndex]));
                else charList.set(i, alphabetArray[newIndex]);
                System.out.print(charList.get(i));
            }
            else System.out.println("nie litera");
        }
        System.out.println();
    }


}
