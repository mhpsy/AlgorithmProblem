package Stream_;

import java.util.Random;
import java.util.stream.Stream;

public class Stream_01 {
    public static void main(String[] args) {

        Stream.of(Stream.iterate(0, i -> i + 1).limit(10).toArray()).forEach(System.out::print);//0123456789
        System.out.println();
        Stream.of(Stream.iterate(5, n -> n + 5).limit(10).toArray()).forEach(v -> System.out.print(v + " "));//5 10 15 20 25 30 35 40 45 50
        System.out.println();

        Stream<String> generate = Stream.generate(() -> {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                sb.append(alphabet.charAt((int) (Math.random() * 26)));
            }
            return sb.toString();
        });
        generate.limit(10).forEach(v -> System.out.print(v + " "));

        System.out.println();

        new Random()
                .ints(10, 0, 100)
                //10是流的长度，0是流的起始值，100是流的结束值
                //但是实际只有9个值 并不是10个值 用起来的时候还是limit好用一些 直观
                .sorted()
                .distinct()
                .forEach(v -> System.out.print(v + " "));

        System.out.println();

        new Random()
                .ints(10, 100)
                .limit(10)
                //limit()方法用于获取指定数量的流，如果流的当前长度大于参数指定的长度，则截断流，否则不做任何处理。
                //但是ints()可以三个参数，第一个参数是流的长度，第二个参数是流的起始值，第三个参数是流的结束值，这样就可以不用limit()方法了。
                .sorted()
                .distinct()
                .forEach(v -> System.out.print(v + " "));




    }
}
