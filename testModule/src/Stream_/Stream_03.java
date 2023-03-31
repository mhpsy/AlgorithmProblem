package Stream_;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_03 {
    public static void main(String[] args) {
//        IntStream.range(1, 10).forEach(System.out::println);

        int sum = IntStream.range(1, 100).sum();
        System.out.println(sum);

        IntStream.Builder builder = IntStream.builder();
        // IntStream果然也有builder java的设计确实顶级没得说
        builder.add(1).add(2).add(3).add(4).add(5);
        System.out.println(builder.build().sum());

        int concatSum = IntStream.concat(IntStream.range(1, 6), IntStream.range(1, 6))
                .sum();
        System.out.println(concatSum);

        //concat()方法用于将两个流连接成一个流

        Random random = new Random(20);
        // new Random() 会产生一个随机数种子，如果不传入参数，每次产生的随机数都不一样，如果传入参数，每次产生的随机数都一样
        // 也就是这个参数是随机数种子，如果传入相同的参数，每次产生的随机数都一样
        Stream<Integer> randomStream = random.ints(10, 20).boxed().limit(20);
//        IntStream is = (IntStream) randomStream.mapToInt(v->v);
//        IntStream is = (IntStream) randomStream.mapToInt(v->v.intValue());
        IntStream is = randomStream.mapToInt(Integer::intValue);
        // 这里的mapToInt()方法是将Stream<Integer>转换成IntStream 不需要强转

        Stream<Integer> boxed = is.boxed();
        // 这里的boxed()方法是将IntStream转换成Stream<Integer> 也就是转换成了Stream<Integer>类型它的包装类型
//        boxed.forEach(System.out::print);
        //1316111115151315131816121510181614181716

        boxed.skip(10).forEach(System.out::print);
        //16121510181614181716

        // skip()方法用于跳过前n个元素 这里是跳过前10个元素

//        System.out.println(is.sum());


    }
}
