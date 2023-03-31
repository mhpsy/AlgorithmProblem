package Stream_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Stream_02 {
    public static void main(String[] args) {
        User a = new User(1, 18, "a");
        User b = new User(2, 19, "b");
        User c = new User(3, 20, "c");
        User aa = new User(1, 18, "a");

//        Stream.of(a, b, c, aa).distinct().forEach(System.out::println);
        Stream.of(a, b, c, aa).distinct().forEach(v -> System.out.print(v.getName() + " ,"));//a ,b ,c ,
        System.out.println();

        List<User> users = Arrays.asList(a, b, c, aa);
        users.stream().distinct().forEach(v -> System.out.print(v.getName() + " ,"));//a ,b ,c ,

        System.out.println();

//        Stream<User> sorted = users.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge());
//        int[] ids = users.stream().sorted(Comparator.comparingInt(User::getAge)).mapToInt(v -> v.getId()).toArray();
        int[] ids = users.stream().sorted(Comparator.comparingInt(User::getAge)).mapToInt(User::getId).toArray();
        System.out.println(Arrays.toString(ids));//[1, 2, 3, 1]

        System.out.println();

        /**
         * 使用建造者模式创建一个 builder 对象，然后将创建流所需的多个信息传递给它，最后 builder 对象执行创建流的操作
         */
        Stream.Builder<User> builder = Stream.builder();
        builder.add(a).add(b).add(c).add(aa);
        // build创建流
        builder.build().forEach(System.out::println);
//         builder.add(a);	// 调用 build() 方法后继续添加元素会产生异常 java.lang.IllegalStateException


    }
}
