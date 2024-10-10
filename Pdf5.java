import java.util.Scanner;

public class Pdf5 {
    public static void zad1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int num = sc.nextInt();
        System.out.println("Iteracyjnie: ");
        int fact = 1;
        for(int i = num; i > 0; i--){
            fact *= i;
        }
        System.out.println(fact);
        System.out.println("Rekurencyjnie: ");
        System.out.println(FactorialRec(num));
    }
    private static int FactorialRec(int num){
        if (num < 0)
            return -1;
        else if (num == 0)
            return 1;
        else {
            return (num * FactorialRec(num - 1));
        }
    }
    public static void Zad2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int num = sc.nextInt();
        System.out.println("Iteracyjnie: ");
        System.out.print("0, ");
        int a = 0, b = 1;
        for(int i = 3; i < num; i++){
            System.out.print(b + ", ");
            b += a;
            a = b-a;
        }
        System.out.println("Rekurencyjnie: ");

    }


}
