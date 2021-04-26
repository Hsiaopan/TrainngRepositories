package cn.hsiaopan.learnjava;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WeekendFilter {
    public static void main(String[] args) throws Exception{
        Stream.generate(new LocalDateSupplier())
                .limit(31)
                .filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2021, 1, 1);
    int n = -1;

    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
