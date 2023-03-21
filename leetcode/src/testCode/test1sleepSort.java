package testCode;

import java.util.Arrays;

public class test1sleepSort implements Runnable {

    private int number;

    public static void main(String[] args) {
        int[] numbers = new int[]{102, 338, 62, 9132, 580, 666};
        for (int number : numbers) {
            new Thread(new test1sleepSort(number)).start();
        }
        System.out.println(Arrays.toString(numbers));
    }

    public test1sleepSort(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.number);
            System.out.println(this.number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
