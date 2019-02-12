package com.tuandai.thread.stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by liusongrui on 2018/11/30.
 */
public class StreamCase {


    public static void main(String[] args) {

        List<String> words = Arrays.asList("aacc", "bbcc", "cc");


//        long count = words.parallelStream().filter(w -> w.length() > 3).count();
//        System.out.println(count);


//        Stream<Double> stream = Stream.generate(Math::random);
//        stream.forEach(m -> {
//            System.out.println(m);
//        });

        Stream<BigInteger> streams = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(5);
        streams.forEach(m -> {
            try {
                Thread.sleep(1000);
                System.out.println(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


}
