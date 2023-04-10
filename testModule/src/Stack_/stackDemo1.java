package Stack_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class stackDemo1 {
    public static void main(String[] args) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            deque.push(new int[]{i, i * i});
        }

        while (!deque.isEmpty()) {
            System.out.println(Arrays.toString(deque.peek()));
            System.out.println(Arrays.toString(deque.pop()));
        }

    }
}

