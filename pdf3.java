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
                //zad6
                System.out.println("Zad6");
                System.out.print("Wybierz system(1 - ZM, 2 - ZU1, 3 - ZU2): ");
                int system = sc.nextInt();
                System.out.print("Podaj 1 liczbe binarnie: ");
                String bin1 = sc.nextLine();
                bin1 = sc.nextLine();
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

                System.out.println("Zad 7, probowalem i sie poddalem");
                System.out.print("Podaj liczbe 1 binarnie: ");
                String binaryNum1 = sc.nextLine();
                System.out.print("Podaj liczbe 2 binarnie: ");
                String binaryNum2 = sc.nextLine();
                System.out.println(boothMultiplication(binaryNum1, binaryNum2));
                //zad 8

                System.out.println("Zad 8, probowalem i sie poddalem");
                System.out.print("Podaj liczbe 1 binarnie: ");
                String binaryDividend = sc.nextLine();
                System.out.print("Podaj liczbe 1 binarnie:: ");
                String binaryDivisor = sc.nextLine();

                System.out.println("Porownawcza:");
                System.out.println(comparativeDivision(binaryDividend, binaryDivisor));


                System.out.println("nierestytucyjna:");
                System.out.println(nonRestoringDivision(binaryDividend, binaryDivisor));
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

            private static String comparativeDivision(String dividend, String divisor) {
                StringBuilder quotient = new StringBuilder("0".repeat(32));
                StringBuilder remainder = new StringBuilder("0".repeat(32));
                dividend = padTo32Bits(dividend);
                divisor = padTo32Bits(divisor);

                for (int i = 0; i < 32; i++) {
                    remainder.deleteCharAt(0);
                    remainder.append(dividend.charAt(i));

                    if (compare(remainder.toString(), divisor) >= 0) {
                        quotient.setCharAt(i, '1');
                        remainder = new StringBuilder(subtract(remainder.toString(), divisor));
                    }
                }

                return quotient.toString();
            }

            private static String nonRestoringDivision(String dividend, String divisor) {
                StringBuilder quotient = new StringBuilder("0".repeat(32));
                StringBuilder remainder = new StringBuilder("0".repeat(32));
                dividend = padTo32Bits(dividend);
                divisor = padTo32Bits(divisor);
                String negDivisor = negate(divisor);

                for (int i = 0; i < 32; i++) {
                    remainder.deleteCharAt(0);
                    remainder.append(dividend.charAt(i));

                    if (remainder.charAt(0) == '0') {
                        remainder = new StringBuilder(add(remainder.toString(), negDivisor));
                        quotient.setCharAt(i, '1');
                    } else {
                        remainder = new StringBuilder(add(remainder.toString(), divisor));
                        quotient.setCharAt(i, '0');
                    }
                }

                if (remainder.charAt(0) == '1') {
                    remainder = new StringBuilder(add(remainder.toString(), divisor));
                }

                return quotient.toString();
            }

            private static String boothMultiplication(String multiplicand, String multiplier) {
                multiplicand = padTo32Bits(multiplicand);
                multiplier = padTo32Bits(multiplier);
                StringBuilder product = new StringBuilder("0".repeat(64));
                String m = multiplicand + "0".repeat(32);
                String negM = negate(m);
                product.replace(32, 64, multiplier + "0");

                for (int i = 0; i < 32; i++) {
                    String lastTwoBits = product.substring(62, 64);
                    if (lastTwoBits.equals("01")) {
                        String sum = add(product.substring(0, 32), m);
                        product.replace(0, 32, sum);
                    } else if (lastTwoBits.equals("10")) {
                        String sum = add(product.substring(0, 32), negM);
                        product.replace(0, 32, sum);
                    }
                    char msb = product.charAt(0);
                    product.deleteCharAt(63);
                    product.insert(0, msb);
                }
                return product.substring(0, 32);
            }

            private static String padTo32Bits(String binary) {
                return "0".repeat(Math.max(0, 32 - binary.length())) + binary;
            }

            private static String negate(String binary) {
                StringBuilder negated = new StringBuilder();
                for (char bit : binary.toCharArray()) {
                    negated.append(bit == '0' ? '1' : '0');
                }
                return add(negated.toString(), "1" + "0".repeat(63));
            }

            private static int compare(String a, String b) {
                for (int i = 0; i < 32; i++) {
                    if (a.charAt(i) < b.charAt(i)) return -1;
                    if (a.charAt(i) > b.charAt(i)) return 1;
                }
                return 0;
            }

            private static String subtract(String a, String b) {
                return add(a, negate(b));
            }

            private static String add(String a, String b) {
                StringBuilder result = new StringBuilder();
                int carry = 0;
                for (int i = a.length() - 1; i >= 0; i--) {
                    int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
                    result.insert(0, sum % 2);
                    carry = sum / 2;
                }
                return result.toString();
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
        }
