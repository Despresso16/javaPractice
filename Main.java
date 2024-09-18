import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.decrementExact;
import static java.lang.Math.pow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //zad z moodle
//        //zad1
//        System.out.println("Zad1");
//        System.out.printf("Podaj liczbe: ");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        float fNum = Float.valueOf(input);
//        System.out.println("Liczba: " + fNum);
//        //zad2
//        System.out.println("Zad2");
//        int a = 25, b = 7;
//        System.out.println("Dodawanie: " + (a+b));
//        System.out.println("Odejmowanie: " + (a-b));
//        System.out.println("Mnozenie: " + (a*b));
//        System.out.println("Dzielenie: " + (a/b));
//        System.out.println("Modulo: " + (a%b));
//        //zad3
//        System.out.println("Zad3");
//        System.out.printf("Podaj liczbe: ");
//        input = scanner.nextLine();
//        int num = Integer.valueOf(input);
//        if(num % 2 == 0){
//            System.out.println("Ta liczba jest parzysta");
//        }
//        else System.out.println("Ta liczba jest nieparzysta");
//        //zad4
//        System.out.println("Zad4");
//        System.out.printf("Podaj ocene: ");
//        input = scanner.nextLine();
//        num = Integer.valueOf(input);
//        switch (num){
//            case 1:
//                System.out.println("Ocena niedostateczna");
//                break;
//            case 2:
//                System.out.println("Ocena dopuszczajaca");
//                break;
//            case 3:
//                System.out.println("Ocena dostateczny");
//                break;
//            case 4:
//                System.out.println("Ocena dobry");
//                break;
//            case 5:
//                System.out.println("Ocena bardzo dobry");
//                break;
//            case 6:
//                System.out.println("Ocena celujaca");
//                break;
//            default:
//                System.out.println("Nie ma takiej oceny!");
//                break;
//        }
//        //zad5
//        System.out.println("Zad5");
//        System.out.printf("Podaj liczbe ocen: ");
//        int arrayLength = Integer.valueOf(scanner.nextLine());
//        int array[] = new int[arrayLength];
//        float fresult = 0;
//        for(int i = 0; i < arrayLength; i++){
//            array[i] = Integer.valueOf(scanner.nextLine());
//            if(array[i] < 1) array[i] = 1;
//            if(array[i] > 6) array[i] = 6;
//            fresult += array[i];
//        }
//        fresult /= arrayLength;
//        System.out.println("Srednia ocen: " + fresult);
//        //zad6
//        System.out.println("Zad6");
//        System.out.printf("Podaj n: ");
//        int n = Integer.valueOf(scanner.nextLine());
//        int result = 1;
//        for(int i = 2; i <= n; i++){
//            result *= i;
//        }
//        System.out.println("Silnia: " + result);
//        //zad7
//        System.out.println("Zad7");
//        for(int i = 100; i > 0; i -= 2){
//            System.out.printf(i + " ");
//        }

        //pdf nr1
//        //zad1
//        System.out.println("Zad1");
        Scanner sc = new Scanner(System.in);
//        System.out.print("Podaj temp. w st. C: ");
//        Float celsius = Float.valueOf(sc.nextLine());
//        System.out.println("Temperatura w st. F: " + (1.8 * celsius + 32));
//        //zad2
//        System.out.println("Zad2");
//        System.out.print("Podaj 1 liczbe: ");
//        int a = Integer.valueOf(sc.nextLine());
//        System.out.print("Podaj 2 liczbe: ");
//        int b = Integer.valueOf(sc.nextLine());
//        System.out.print("Podaj 3 liczbe: ");
//        int c = Integer.valueOf(sc.nextLine());
//        int max = a;
//        if(max < b) max = b;
//        if(max < c) max = c;
//        System.out.println("Najwieksza liczba: " + max);
//        //zad3
//        System.out.println("Zad3");
//        System.out.print("Podaj wage w kg: ");
//        double waga = sc.nextDouble();
//        System.out.print("Podaj wzrost w metrach: ");
//        double wzrost = sc.nextDouble();
//        Double bmi = waga / Math.pow(wzrost, 2);
//        System.out.println("BMI: " + String.format("%.2f", bmi));
//        //zad4
//        System.out.println("Zad4");
//        System.out.print("Podaj dochod: ");
//        double dochod = sc.nextDouble();
//        double podatek = 0;
//        if(dochod < 85528){
//            podatek = (dochod  - 556.02) * 0.18;
//        }
//        else podatek = 14839.02 + ((dochod - 85528) * 0.32);
//        System.out.print("Twoj podatek wynosi: " + String.format("%.2f", podatek));
//        //zad5
//        System.out.println("Zad5");
//        System.out.print("Podaj cene (od 100zl do 10000zl): ");
//        double cena = sc.nextDouble();
//        if(cena > 10000) cena = 10000;
//        else if(cena < 100) cena = 100;
//        System.out.print("Podaj ilosc rat (od 6 do 48): ");
//        int liczbaRat = sc.nextInt();
//        if(liczbaRat > 48) liczbaRat = 48;
//        else if(liczbaRat < 6) liczbaRat = 6;
//        double procent = 0.0;
//        if(liczbaRat < 12) procent = 2.5;
//        else if(liczbaRat > 12 && liczbaRat <24) procent = 5;
//        else procent = 10;
//        double rata = (cena / liczbaRat) * (1.0 + (procent / 100));
//        double odsetki = (cena / liczbaRat) * (1.0 + (procent / 100)) * 31/365;
//        System.out.println("Miesieczna rata: " + String.format("%.2f", rata) + "| odsetki: " + String.format("%.2f", odsetki));
//        //zad 6
//        String endInput = "reset";
//        float result = 0;
//        boolean cont = false;
//        int num1 = 0;
//        String operator = "";
//        System.out.println("Zad6");
//        while(!Objects.equals(endInput, "")){
//            if(cont) {
//                num1 = (int) result;
//            }
//            else{
//                num1 = sc.nextInt();
//            }
//            operator = sc.next();
//            if(!Objects.equals(operator, "+") && !Objects.equals(operator, "-") && !Objects.equals(operator, "*") && !Objects.equals(operator, "/")){
//                System.out.println(operator);
//                System.out.println("Taki operator nie istnieje");
//                continue;
//            }
//            int num2 = sc.nextInt();
//            if(operator.equals("+")){
//                result = num1 + num2;
//            }
//            else if(operator.equals("-")){
//                result = num1 - num2;
//            }
//            else if(operator.equals("*")){
//                result = num1 * num2;
//            }
//            else if(operator.equals("/")){
//                result = num1 / num2;
//            }
//            System.out.println("= " + String.format("%.2f", result));
//            System.out.println("Zakoncz- wpisz end | Koontynuuj - wpisz cont | Zresetuj - wpisz reset: ");
//            endInput = sc.next();
//            if(Objects.equals(endInput, "end")){
//                break;
//            }
//            else if(Objects.equals(endInput, "reset")){
//                System.out.println("Zresetowano!");
//            }
//            else {
//                cont = true;
//                System.out.println((int) result);
//            }
//        }
        //pdf nr 2

        //zad 1
        System.out.println("Zad1");
        System.out.print("Podaj liczbe dodatnia: ");
        int num = sc.nextInt();
        if(num < 0){
            System.out.println("Miales podac dodatnia");
            num *= -1;
        }
        for(int i = 1; i < num; i += 2){
            System.out.println(i);
        }
        //zad 1
        System.out.println("Zad2");
        //...
    }
}