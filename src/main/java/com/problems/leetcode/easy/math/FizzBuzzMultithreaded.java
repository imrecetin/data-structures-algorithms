package com.problems.leetcode.easy.math;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

    private int n;
    private int count;
    private Object lock;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        this.count = 1;
        this.lock = new Object();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(count<=n) {
            synchronized (lock) {
                if (count<=n && count % 3 == 0 && count % 5 != 0) {
                    printFizz.run();
                    count++;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(count<=n) {
            synchronized (lock) {
                if (count<=n && count % 5 == 0 && count % 3 != 0) {
                    printBuzz.run();
                    count++;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count<=n) {
            synchronized (lock) {
                if (count<=n && count % 5 == 0 && count % 3 == 0) {
                    printFizzBuzz.run();
                    count++;
                }
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(count<=n) {
            synchronized (lock) {
                if (count<=n && count % 3 != 0 && count % 5 != 0) {
                    printNumber.accept(count);
                    count++;
                }
            }
        }
    }

    /**
     * Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
     * Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
     * Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
     * Thread D will call number() which should only output the numbers.
     * */
}
