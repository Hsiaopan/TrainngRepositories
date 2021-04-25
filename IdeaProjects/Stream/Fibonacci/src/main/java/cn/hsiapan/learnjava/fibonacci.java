package cn.hsiapan.learnjava;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class fibonacci {
    public static void main(String[] args) throws IOException {
        Stream<BigInteger> steam = Stream.generate(new FibSupplier());
        steam.limit(50).forEach(System.out::println);
    }

}

//class FibSupplier implements LongSupplier {
//    long i = 0L;
//    long j = 0L;
//    long k = 1L;
//
//    @Override
//    public long getAsLong() {
//        i = j;
//        j = k;
//        k = i + j;
//        return j;
//
//    }
//}

class FibSupplier implements Supplier<BigInteger> {
    private static Queue<BigInteger> fibQueue = new LinkedList<>();

    static {
        fibQueue.add(new BigInteger("0"));
        fibQueue.add(new BigInteger("1"));
    }

    @Override
    public BigInteger get(){
       BigInteger prev = fibQueue.poll();
       fibQueue.add(prev.add(fibQueue.peek()));
       return fibQueue.peek();

    }
}


