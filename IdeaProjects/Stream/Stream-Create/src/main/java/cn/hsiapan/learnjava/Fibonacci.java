package cn.hsiapan.learnjava;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        Stream<BigInteger> steam = Stream.generate(new FibSupplier());
        steam.limit(50).forEach(System.out::println);
    }

}


class FibSupplier implements Supplier<BigInteger> {
    private static final Queue<BigInteger> fibQueue = new LinkedList<>();

    static {
        fibQueue.add(new BigInteger("0"));
        fibQueue.add(new BigInteger("1"));
    }

    @Override
    public BigInteger get() {
        BigInteger prev = fibQueue.poll();
        fibQueue.add(fibQueue.peek().add(prev));
        return fibQueue.peek();

    }
}


