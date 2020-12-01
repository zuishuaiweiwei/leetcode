import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @lc app=leetcode.cn id=1195 lang=java
 *
 * [1195] 交替打印字符串
 */

// @lc code=start
class FizzBuzz {
    private int n;
    private ReentrantLock lock =new ReentrantLock();
    private Condition fizz = lock.newCondition();
    private Condition buzz = lock.newCondition();
    private Condition fizzbuzz = lock.newCondition();
    private Condition number = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 5 != 0) {
                fizz.await();
                printFizz.run();
                number.signal();
            }
        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 != 0) {
                buzz.await();
                printBuzz.run();
                number.signal();
            }
        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        for (int i = 15; i <= n; i = i + 15) {
            fizzbuzz.await();
            printFizzBuzz.run();
            number.signal();
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                fizzbuzz.signal();
                number.await();
            } else if (i % 5 == 0) {
                buzz.signal();
                number.await();
            } else if (i % 3 == 0) {
                fizz.signal();
                number.await();
            } else {
                printNumber.accept(i);
            }
        }
        lock.unlock();
    }
}
// @lc code=end
