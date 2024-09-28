import java.util.*;

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
                System.out.print("Podaj liczbe calkowita: ");
                String binaryString = "0.";
                double num = (double)sc.nextInt();
                if(num < 0){
                    num *= -1;
                    binaryString = "1.";
                }
                List<Integer> binaryArray = new ArrayList<>();
                while(true){
                    binaryArray.add((int)(num % 2));
                    if(num > 1.0) num = (double)((int)num / 2);
                    if(num == 1.0){
                        binaryArray.add((int)(num % 2));
                        break;
                    }
                }
                for(int i = binaryArray.size() - 1; i >= 0; i--){
                    binaryString += String.valueOf(binaryArray.get(i));
                }
                System.out.println(binaryString);
                //zad5
                System.out.println("Zad5");
                System.out.print("Podaj liczbe calkowita: ");
                num = (double)sc.nextInt();
                double numCopy = num;
                //zu1
                binaryString = "0.";
                if(num < 0){
                    num *= -1;
                    binaryString = "1.";
                }
                binaryArray = new ArrayList<>();
                while(true){
                    binaryArray.add((int)(num % 2));
                    if(num > 1.0) num = (double)((int)num / 2);
                    if(num == 1){
                        binaryArray.add((int)(num % 2));
                        break;
                    }
                }
                for(int i = binaryArray.size() - 1; i >= 0; i--){
                    if(binaryString.charAt(0) == '1'){
                        if(binaryArray.get(i) == 0 ) binaryArray.set(i, 1);
                        else if(binaryArray.get(i) == 1 ) binaryArray.set(i, 0);
                    }
                    binaryString += String.valueOf(binaryArray.get(i));
                }
                System.out.println("ZU1: " + binaryString);
                //zu2
                num = numCopy + 1;
                binaryString = "0.";
                if(num < 0){
                    num *= -1;
                    binaryString = "1.";
                }
                binaryArray = new ArrayList<>();
                while(true){
                    binaryArray.add((int)(num % 2));
                    if(num > 1.0) num = (double)(num / 2);
                    if((int)num <= 1){
                        binaryArray.add((int)(num % 2));
                        break;
                    }
                }
                for(int i = binaryArray.size() - 1; i >= 0; i--){
                    if(binaryString.charAt(0) == '1'){
                        if(binaryArray.get(i) == 0 ) binaryArray.set(i, 1);
                        else if(binaryArray.get(i) == 1 ) binaryArray.set(i, 0);
                    }
                    binaryString += String.valueOf(binaryArray.get(i));
                }
                System.out.println("ZU2: " + binaryString);
                //zad5
                System.out.println("Zad6");
                System.out.print("Wybierz system(1 - ZM, 2 - ZU1, 3 - ZU2): ");
                int system = sc.nextInt();
                System.out.print("Podaj 1 liczbe binarnie: ");
                String bin1 = sc.nextLine();
                System.out.print("Podaj 2 liczbe binarnie: ");
                String bin2 = sc.nextLine();
                int bitLength = Math.max(bin1.length(), bin2.length());
                String result = "";
                if (system == 1) {
                    result = addZM(bin1, bin2, bitLength);
                }
                else if (system == 2) {
                    result = addZU1(bin1, bin2, bitLength);
                }
                else if (system == 3) {
                    result = addZU2(bin1, bin2, bitLength);
                }
                System.out.println("Wynik: " + result);
                //zad 7
                System.out.println("Zad 7 (Obie liczby powinny byc tej samej długości!)");
                System.out.print("Podaj liczbe 1 binarnie: ");
                String binaryNum1 = sc.nextLine();
                System.out.print("Podaj liczbe 2 binarnie: ");
                String binaryNum2 = sc.nextLine();
                if (binaryNum1.length() != binaryNum2.length()) {
                    System.out.println("Nierowna dlugosc!");
                }
                else boothMultiplication(binaryNum1, binaryNum2);
                //zad 8
                System.out.println("Zad 8 (Obie liczby powinny byc tej samej długości!)");
                System.out.print("Ponam 1 liczbe binarnie: ");
                binaryNum1 = sc.nextLine();
                System.out.print("Ponam 2 liczbe binarnie: ");
                binaryNum2 = sc.nextLine();
                if (binaryNum1.length() != binaryNum2.length()) {
                    System.out.println("Nierowna dlugosc");
                }
                else{
                    compareDivision(binaryNum1, binaryNum2);
                    nonRestoringDivision(binaryNum1, binaryNum2);
                }
                //zad 9
                System.out.println("Zad 9");
                System.out.print("Podaj liczbe n: ");
                int n = sc.nextInt();
                if(n < 0) n *= -1;
                Boolean[][] boolArray = new Boolean[n][n];
                for(int i = 0; i < n; i++){
                    List<Integer> iDidviders = new ArrayList<>();
                    for(int l = 1; l <= i + 1; l++){
                        if((i + 1) % l == 0) iDidviders.add(l);
                    }
                    for(int j = 0; j < n; j++){
                        Boolean isRelFirst = true;
                        for(int l = 1; l <= j + 1; l++){
                            if((j + 1) % l == 0 && iDidviders.contains(l) && l != 1){
                                isRelFirst = false;
                                break;
                            }
                        }
                        boolArray[i][j] = isRelFirst;
                    }
                }
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(boolArray[i][j]) System.out.print("+ ");
                        else System.out.print(". ");
                    }
                    System.out.println();
                }
            }
            public static String addBinary(String a, String b) {
                StringBuilder result = new StringBuilder();
                int carry = 0;
                int length = a.length();
                for (int i = length - 1; i >= 0; i--) {
                    int bitA = a.charAt(i) - '0';
                    int bitB = b.charAt(i) - '0';
                    int sum = bitA + bitB + carry;
                    result.insert(0, sum % 2);
                    carry = sum / 2;
                }
                if (carry > 0) {
                    result.insert(0, carry);
                }
                return result.toString();
            }
            public static String twosComplement(String binary) {
                StringBuilder onesComplement = new StringBuilder();
                for (char bit : binary.toCharArray()) {
                    onesComplement.append(bit == '0' ? '1' : '0');
                }
                return addBinary(onesComplement.toString(), "1");
            }
            public static String arithmeticShiftRight(String acc, String q, char q_1) {
                char signBit = acc.charAt(0);
                acc = signBit + acc.substring(0, acc.length() - 1);
                q = acc.charAt(acc.length() - 1) + q.substring(0, q.length() - 1);
                return acc + q + q_1;
            }
            public static void boothMultiplication(String num1, String num2) {
                int num1Len = num1.length();
                String acc = "0".repeat(num1Len);
                char charNum2 = '0';
                String num1Minus = twosComplement(num1);
                for (int i = 0; i < num1Len; i++) {
                    if (num2.charAt(num2.length() - 1) == '1' && charNum2 == '0') {
                        acc = addBinary(acc, num1Minus);
                    } else if (num2.charAt(num2.length() - 1) == '0' && charNum2 == '1') {
                        acc = addBinary(acc, num1);
                    }
                    String combined = arithmeticShiftRight(acc, num2, charNum2);
                    acc = combined.substring(0, num1Len);
                    num2 = combined.substring(num1Len, 2 * num1Len);
                    charNum2 = combined.charAt(combined.length() - 1);

                }
                System.out.println("Wynik: " + acc + num2);
            }
            public static String addZM(String bin1, String bin2, int bitLength) {
                int sign1 = bin1.charAt(0) == '1' ? -1 : 1;
                int sign2 = bin2.charAt(0) == '1' ? -1 : 1;
                String absBin1 = bin1.substring(1);
                String absBin2 = bin2.substring(1);
                int num1 = sign1 * Integer.parseInt(absBin1, 2);
                int num2 = sign2 * Integer.parseInt(absBin2, 2);
                int result = num1 + num2;
                String binaryResult = Integer.toBinaryString(Math.abs(result));
                binaryResult = String.format("%" + (bitLength - 1) + "s", binaryResult).replace(' ', '0');
                if (result < 0) {
                    return "1" + binaryResult;
                } else {
                    return "0" + binaryResult;
                }
            }
            public static String addZU1(String bin1, String bin2, int bitLength) {
                int num1 = fromZU1(bin1);
                int num2 = fromZU1(bin2);
                int result = num1 + num2;
                return toZU1(result, bitLength);
            }
            public static String addZU2(String bin1, String bin2, int bitLength) {
                int num1 = fromZU2(bin1);
                int num2 = fromZU2(bin2);
                int result = num1 + num2;
                return toZU2(result, bitLength);
            }
            public static int fromZU1(String binary) {
                if (binary.charAt(0) == '0') {
                    return Integer.parseInt(binary, 2);
                } else {
                    String inverted = invert(binary.substring(1));
                    int absValue = Integer.parseInt(inverted, 2);
                    return -(absValue);
                }
            }
            public static int fromZU2(String binary) {
                if (binary.charAt(0) == '0') {
                    return Integer.parseInt(binary, 2);
                } else {
                    int twoComplement = Integer.parseInt(binary, 2);
                    int maxValue = (int) Math.pow(2, binary.length());
                    return twoComplement - maxValue;
                }
            }
            public static String toZU1(int number, int bitSize) {
                if (number >= 0) {
                    return String.format("%" + bitSize + "s", Integer.toBinaryString(number)).replace(' ', '0');
                } else {
                    String binary = Integer.toBinaryString(-number);
                    binary = String.format("%" + bitSize + "s", binary).replace(' ', '0');
                    return "1" + invert(binary.substring(1));
                }
            }
            public static String toZU2(int number, int bitSize) {
                if (number >= 0) {
                    return String.format("%" + bitSize + "s", Integer.toBinaryString(number)).replace(' ', '0');
                } else {
                    int maxValue = (int) Math.pow(2, bitSize);
                    return Integer.toBinaryString(maxValue + number).substring(1);
                }
            }
            public static String invert(String binary) {
                StringBuilder result = new StringBuilder();
                for (char bit : binary.toCharArray()) {
                    result.append(bit == '0' ? '1' : '0');
                }
                return result.toString();
            }
            public static String subtractBinary(String a, String b) {
                String bComplement = twosComplement(b);
                return addBinary(a, bComplement);
            }
            public static String padBinary(String binary, int length) {
                while (binary.length() < length) {
                    binary = "0" + binary;
                }
                return binary;
            }
            public static int compareBinary(String a, String b) {
                int length = Math.max(a.length(), b.length());
                a = padBinary(a, length);
                b = padBinary(b, length);

                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
            public static void compareDivision(String num1, String num2) {
                int n = num1.length();
                String quotient = "";
                String rest = num1;
                System.out.println("Metoda porównawcza (zrestytucyjna):");
                for (int i = 0; i < n; i++) {
                    rest = rest.substring(1) + "0";
                    if (compareBinary(rest, num2) >= 0) {
                        rest = subtractBinary(rest, num2);
                        quotient += "1";
                    } else {
                        quotient += "0";
                    }
                }
                System.out.println("Wynik: " + quotient + ", Reszta: " + rest);
            }
            public static void nonRestoringDivision(String num1, String num2) {
                int n = num1.length();
                String quotient = "";
                String rest = num1;
                System.out.println("Metoda nierestytucyjna:");
                for (int i = 0; i < n; i++) {
                    rest = rest.substring(1) + "0";
                    if (rest.charAt(0) == '0') {
                        rest = subtractBinary(rest, num2);
                        quotient += "1";
                    } else {
                        rest = addBinary(rest, num2);
                        quotient += "0";
                    }
                }
                System.out.println("Wynik: " + quotient + ", Reszta: " + rest);
            }
        }
