package testCode;

import java.util.Arrays;
import java.util.Scanner;

public class homeWork1 {
    public static void main(String[] args) {
        new task();
    }
}

class task {
    public task() {
        while (true) {
            System.out.println("Enter Your Choice");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("Q")) {
                break;
            }
            System.out.println("Enter First Vector:");
            String firstVector = scanner.nextLine();
            System.out.println("Enter Second Vector:");
            String secondVector = scanner.nextLine();
            String[] firstVectorArray = firstVector.split(" ");
            String[] secondVectorArray = secondVector.split(" ");
            int[] firstVectorIntArray = new int[firstVectorArray.length];
            int[] secondVectorIntArray = new int[secondVectorArray.length];
            for (int i = 0; i < firstVectorArray.length; i++) {
                firstVectorIntArray[i] = Integer.parseInt(firstVectorArray[i]);
            }
            for (int i = 0; i < secondVectorArray.length; i++) {
                secondVectorIntArray[i] = Integer.parseInt(secondVectorArray[i]);
            }
            int[] result = new int[firstVectorIntArray.length];

            if (choice.equalsIgnoreCase("A")) {//Add
                if (!isLengthEq(firstVectorIntArray.length, secondVectorIntArray.length)) break;

                for (int i = 0; i < firstVectorIntArray.length; i++) {
                    result[i] = firstVectorIntArray[i] + secondVectorIntArray[i];
                }
                System.out.println(Arrays.toString(result));
            } else if (choice.equalsIgnoreCase("D")) {//Dot Product
                if (!isLengthEq(firstVectorIntArray.length, secondVectorIntArray.length)) break;

                for (int i = 0; i < firstVectorIntArray.length; i++) {
                    result[i] = firstVectorIntArray[i] * secondVectorIntArray[i];
                }
                int sum = 0;
                for (int i : result) {
                    sum += i;
                }
                System.out.println(sum);
            } else if (choice.equalsIgnoreCase("M")) {//Multiply
                if (!isLengthEq(firstVectorIntArray.length, secondVectorIntArray.length)) break;

                for (int i = 0; i < firstVectorIntArray.length; i++) {
                    result[i] = firstVectorIntArray[i] * secondVectorIntArray[i];
                }
                System.out.println(Arrays.toString(result));
            } else if (choice.equalsIgnoreCase("E")) {//Equality
                if (!isLengthEq(firstVectorIntArray.length, secondVectorIntArray.length)) break;

                if (Arrays.equals(firstVectorIntArray, secondVectorIntArray)) {
                    System.out.println("Vectors are equal");
                } else {
                    System.out.println("Vectors are not equal");
                }
            } else if (choice.equalsIgnoreCase("S")) {//Subtract
                if (!isLengthEq(firstVectorIntArray.length, secondVectorIntArray.length)) break;

                for (int i = 0; i < firstVectorIntArray.length; i++) {
                    result[i] = firstVectorIntArray[i] - secondVectorIntArray[i];
                }
                System.out.println(Arrays.toString(result));
            } else if (choice.equalsIgnoreCase("Q")) {//Quit program
                System.out.println("Program terminating normally...");
                System.exit(0);
            } else {
                System.out.println("Wrong Choice");
            }
        }
    }

    public boolean isLengthEq(int l1, int l2) {
        return l1 == l2;
    }
}