package Lesson2.AtomicCalculator;

import java.util.concurrent.atomic.*;

public class MainAtomicCalculator {
    public static void main(String[] args) {
        AtomicCalculator atomicCalculator = new AtomicCalculator();
        AtomicInteger atomicInteger = new AtomicInteger(2);
        AtomicInteger atomicInteger2 = new AtomicInteger(5);
        System.out.println(atomicCalculator.addNUmbers(atomicInteger,atomicInteger2));
        System.out.println(atomicCalculator.minusNUmbers(atomicInteger,atomicInteger2));
        System.out.println(atomicCalculator.multiplyNUmbers(atomicInteger,atomicInteger2));
        System.out.println(atomicCalculator.divideNUmbers(atomicInteger,atomicInteger2));
    }
}
