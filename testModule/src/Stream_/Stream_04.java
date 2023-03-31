package Stream_;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_04 {
    public static void main(String[] args) {
        Pattern.compile("[.,?]+").splitAsStream("a,b,c,d,e").forEach(System.out::print);
        //abcde

        System.out.println();

        Stream<String> stringStream = Pattern.compile("[.,?]+").splitAsStream("a,b,c,d,e");
//        long count = stringStream.count();
//        System.out.println(count);//5
        IntStream intStream = stringStream.mapToInt((v) -> {
            char[] chars = v.toCharArray();
            System.out.println(chars[0] + " " + (int) chars[0]);
            return (int) chars[0];
        });
        int sum = intStream.sum();
        System.out.println(sum);//abcde的ascii码之和

    }
}


