import java.util.*;


import static java.lang.Math.decrementExact;
import static java.lang.Math.pow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //pdf nr1
        //zad1
        System.out.println("Zad1");
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.print("Podaj temp. w st. C: ");
        Float celsius = Float.valueOf(sc.nextLine());
        System.out.println("Temperatura w st. F: " + (1.8 * celsius + 32));
        //zad2
        System.out.println("Zad2");
        System.out.print("Podaj 1 liczbe: ");
        int a = Integer.valueOf(sc.nextLine());
        System.out.print("Podaj 2 liczbe: ");
        int b = Integer.valueOf(sc.nextLine());
        System.out.print("Podaj 3 liczbe: ");
        int c = Integer.valueOf(sc.nextLine());
        int max = a;
        if(max < b) max = b;
        if(max < c) max = c;
        System.out.println("Najwieksza liczba: " + max);
        //zad3
        System.out.println("Zad3");
        System.out.print("Podaj wage w kg: ");
        double waga = sc.nextDouble();
        System.out.print("Podaj wzrost w metrach: ");
        double wzrost = sc.nextDouble();
        Double bmi = waga / Math.pow(wzrost, 2);
        System.out.println("BMI: " + String.format("%.2f", bmi));
        //zad4
        System.out.println("Zad4");
        System.out.print("Podaj dochod: ");
        double dochod = sc.nextDouble();
        double podatek = 0;
        if(dochod < 85528){
            podatek = (dochod  - 556.02) * 0.18;
        }
        else podatek = 14839.02 + ((dochod - 85528) * 0.32);
        System.out.print("Twoj podatek wynosi: " + String.format("%.2f", podatek));
        //zad5
        System.out.println("Zad5");
        System.out.print("Podaj cene (od 100zl do 10000zl): ");
        double cena = sc.nextDouble();
        if(cena > 10000) cena = 10000;
        else if(cena < 100) cena = 100;
        System.out.print("Podaj ilosc rat (od 6 do 48): ");
        int liczbaRat = sc.nextInt();
        if(liczbaRat > 48) liczbaRat = 48;
        else if(liczbaRat < 6) liczbaRat = 6;
        double procent = 0.0;
        if(liczbaRat < 12) procent = 2.5;
        else if(liczbaRat > 12 && liczbaRat <24) procent = 5;
        else procent = 10;
        double rata = (cena / liczbaRat) * (1.0 + (procent / 100));
        double odsetki = (cena / liczbaRat) * (1.0 + (procent / 100)) * 31/365;
        System.out.println("Miesieczna rata: " + String.format("%.2f", rata) + "| odsetki: " + String.format("%.2f", odsetki));
        //zad 6
        String endInput = "reset";
        float result = 0;
        boolean cont = false;
        int num1 = 0;
        String operator = "";
        System.out.println("Zad6");
        while(!Objects.equals(endInput, "")){
            if(cont) {
                num1 = (int) result;
            }
            else{
                num1 = sc.nextInt();
            }
            operator = sc.next();
            if(!Objects.equals(operator, "+") && !Objects.equals(operator, "-") && !Objects.equals(operator, "*") && !Objects.equals(operator, "/")){
                System.out.println(operator);
                System.out.println("Taki operator nie istnieje");
                continue;
            }
            int num2 = sc.nextInt();
            if(operator.equals("+")){
                result = num1 + num2;
            }
            else if(operator.equals("-")){
                result = num1 - num2;
            }
            else if(operator.equals("*")){
                result = num1 * num2;
            }
            else if(operator.equals("/")){
                result = num1 / num2;
            }
            System.out.println("= " + String.format("%.2f", result));
            System.out.println("Zakoncz- wpisz end | Koontynuuj - wpisz cont | Zresetuj - wpisz reset: ");
            endInput = sc.next();
            if(Objects.equals(endInput, "end")){
                break;
            }
            else if(Objects.equals(endInput, "reset")){
                System.out.println("Zresetowano!");
            }
            else {
                cont = true;
                System.out.println((int) result);
            }
        }
        //pdf nr 2

        //zad 1
        System.out.println("Zad1");
        System.out.print("Podaj liczbe dodatnia: ");
        num = sc.nextInt();
        if(num < 0){
            System.out.println("Miales podac dodatnia");
            num *= -1;
        }
        for(int i = 1; i < num; i += 2){
            System.out.println(i);
        }
        //zad 2
        System.out.println("Zad2");
        int A = 0;
        System.out.print("Podaj liczbe A: ");
        A = sc.nextInt();
        int B = A - 1;
        while(A >= B){
            System.out.print("Podaj liczbe B (wieksze od A): ");
            B = sc.nextInt();
            if(A > B) System.out.println("B musi być większe");
        }
        while(A <= B){
            System.out.print(A + ", ");
            A++;
        }
        System.out.println((" "));
        //zad 3
        System.out.println("Zad3");
        System.out.print("Podaj liczbe dodatnia: ");
        num = sc.nextInt();
        if(num < 0){
            System.out.println("Miales podac dodatnia");
            num *= -1;
        }
        for(int i = 1; i < num; i *= 2){
            System.out.print(i + ", ");
        }
        System.out.println((" "));
        //zad 4
        System.out.println("Zad4");
        num = 1;
        int sum = 0;
        while(num != 0){
            System.out.print("Podaj liczbe lub 0 aby zakonczyc: ");
            num = sc.nextInt();
            sum += num;
        }
        System.out.println("Suma: " + sum);
        //zad 5
        System.out.println("Zad5");
        List<Integer> numList = new ArrayList<>();
        num = 1;
        while(num != 0){
            System.out.print("Podaj liczbe lub 0 aby zakonczyc: ");
            num = sc.nextInt();
            if(num != 0){
                numList.add(num);
            }
        }
        int min= numList.get(0);
        max = numList.get(0);
        for(int i = 1; i < numList.size(); i++){
            if(min > numList.get(i)) min = numList.get(i);
            if(max < numList.get(i)) max = numList.get(i);
        }
        int avg = (min + max) / 2;
        System.out.println("Min: " + min + " Max: " + max + " Avg min i max: " + avg);
        //zad 6
        System.out.println("Zad6");
        Random rnd = new Random();
        int rndNum = rnd.nextInt(100) + 1;
        while(rndNum != num){
            System.out.print("Zgadnij liczbe od 1 do 100: ");
            num = sc.nextInt();
            if(num > rndNum) System.out.println("Podałeś za dużą wartość");
            else if (num < rndNum) System.out.println("Podałeś za małą wartość");
            else System.out.println("Gratulacje!");
        }
        //zad 7
        System.out.println("Zad7");
        System.out.print("Podaj znak wypelnienia prostokata: ");
        char fillerChar = sc.next().charAt(0);
        System.out.println(fillerChar);
        int x, y;
        System.out.print("Podaj pozycje x lewego rogu: ");
        x = sc.nextInt();
        System.out.print("Podaj pozycje y lewego rogu: ");
        y = sc.nextInt();
        System.out.print("Podaj dlugosc boku a: ");
        a = sc.nextInt();
        System.out.print("Podaj dlugosc boku b: ");
        b = sc.nextInt();
        for (int i = 1; i <= y + b; i++) {
            for (int j = 1; j <= x + a; j++) {
                if (i <= y || j <= x) {
                    System.out.print(' ');
                } else {
                    System.out.print(fillerChar);
                }
            }
            System.out.println();
        }
        //zad 8
        System.out.println("Zad8");
        System.out.print("Podaj wysokosc choinki: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Wysokosc choinki musi być wieksza niz 0.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //zad 9
        System.out.println("Zad9");
        System.out.print("Podaj liczbę calkowita: ");
        int number = sc.nextInt();
        int sumOfDigits = 0;
        int evenSum = 0, oddSum = 0;
        int evenCount = 0, oddCount = 0;
        int tempNumber = Math.abs(number);
        while (tempNumber > 0) {
            int digit = tempNumber % 10;
            sumOfDigits += digit;

            if (digit % 2 == 0) {
                evenSum += digit;
                evenCount++;
            } else {
                oddSum += digit;
                oddCount++;
            }

            tempNumber /= 10;
        }
        System.out.println("Suma cyfr: " + sumOfDigits);
        double evenAvg = evenCount > 0 ? (double) evenSum / evenCount : 0;
        double oddAvg = oddCount > 0 ? (double) oddSum / oddCount : 0;
        System.out.println("Średnia parzystych: " + evenCount);
        System.out.println("Średnia nieparzystych: " + oddCount);
        if (evenCount > 0 && oddCount > 0) {
            double ratio = evenAvg / oddAvg;
            System.out.println("Stosunek średniej cyfr parzystych do nieparzystych: " + String.format("%.2f", ratio));
        } else {
            System.out.println("Nie można obliczyć stosunku");
        }
        //zad 10
        System.out.println("Zad10");
        System.out.print("Podaj liczbe: ");
        num = sc.nextInt();
        for(int i = 1; i <= num; i++){
            if(num % i == 0) System.out.print(i + ", ");
        }
        System.out.println();
        //zad 11
        System.out.println("Zad11");
        System.out.print("Podaj liczbe: ");
        boolean jestPierwsza = true;
        num = sc.nextInt();
        for(int i = 2; i < num; i++){
            if(num % i == 0) jestPierwsza = false;
        }
        if(jestPierwsza) System.out.println("Ta liczba jest pierwsza");
        else System.out.println("Ta liczba nie jest pierwsza");
    }
}
