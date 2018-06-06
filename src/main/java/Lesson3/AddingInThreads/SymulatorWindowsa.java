package Lesson3.AddingInThreads;

import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;

public class SymulatorWindowsa {

    public static void sumuj(List<Integer> integers) throws InterruptedException {
        Thread.sleep(10000);

        System.err.println( integers.stream().mapToInt(Integer::intValue).sum());
    }
}
