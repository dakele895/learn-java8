package io.github.biezhi.java8.lambda.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

/**
 * 函数式接口示例
 *
 * @author biezhi
 * @date 2018/2/10
 */
public class FunctionalDemo {

    /**
     * 断言
     */
    public void predicate() {
        Predicate<String> namesStartingWithS = name -> name.startsWith("s");
        boolean           hello              = namesStartingWithS.test("Hello");
        // false
    }

    /**
     * 消费数据
     */
    public void consumer() {
        Consumer<String> messageConsumer = message -> System.out.println(message);
        messageConsumer.accept("Learn Java8");  // Learn Java8"

    }

    /**
     * 转换
     */
    public void function() {
        Function<String, String> toUpperCase = name -> name.toUpperCase();
        toUpperCase.apply("Java"); // Java
    }

    /**
     * 提供数据
     */
    public void supplier() {
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());

    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i);
        }

        list.forEach(integer -> {
            System.out.println(integer);
        });




    }
}
