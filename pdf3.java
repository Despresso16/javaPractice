import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        //zad1
        System.out.println("Zad1");
        int[] numArray = new int[10];
        int min = 10, max = -10;
        int avg = 0;
        int index = 0;
        for(int num : numArray){
            num = rnd.nextInt(20) - 9;
            numArray[index] = num;
            System.out.print(num + ", ");
            if(min > num) min = num;
            if(max < num) max = num;
            avg += num;
            index++;
        }
        System.out.println(" ");
        avg /= numArray.length;
        int less = 0, more = 0;
        for(int num : numArray){
            System.out.print(num + ", ");
            if(num < avg) less += 1;
            if(num > avg) more += 1;
        }
        System.out.println("\nMin: " + min + " Max: " + max + "\nAvg: " + avg + " Mniej niz avg:" + less + " Wiecej niz avg: " + more);
        for(int i = numArray.length - 1; i >= 0; i-- ){
            System.out.print(numArray[i] + ", ");
        }
        //zad2
        System.out.println("\nZad2");
        numArray = new int[20];
        System.out.print("Wylosowane liczby: ");
        for(int i = 0; i < numArray.length; i++){
            numArray[i] = rnd.nextInt(10) + 1;
            System.out.print(numArray[i] + ", ");
        }
        System.out.println("\nWystapienia:");
        List<Integer> displayedNums = new ArrayList();
        for(int numDisplay : numArray){
            if(displayedNums.contains(numDisplay)) continue;
            else displayedNums.add(numDisplay);
            int wystap = 0;
            for(int num : numArray){
                if(num == numDisplay) wystap++;
            }
            System.out.println(numDisplay + " - " + wystap);
        }
        //zad3
        System.out.println("Zad3");
        int[][] numMulti = new int[5][5];
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                numMulti[i][j] = rnd.nextInt(10) -4;
                System.out.print(numMulti[i][j] + ", ");
            }
        }
        System.out.println();
        int kolumnaCount = 0;
        for(int j = 0; j < 5; j++){
            kolumnaCount = j + 1;
            min = 5;
            max = -5;
            for (int i = 0; i < 5; i++){
                if(min > numMulti[i][j]) min = numMulti[i][j];
                if(max < numMulti[i][j]) max = numMulti[i][j];
            }
            System.out.println("Kolumna " + kolumnaCount + " Min: " + min + " Max: " + max);
        }
        //zad4
        System.out.println("Zad4");



    }
}
