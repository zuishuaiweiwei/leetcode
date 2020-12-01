import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @lc app=leetcode.cn id=1116 lang=java
 *
 * [1116] 打印零与奇偶数
 */

// @lc code=start
class ZeroEvenOdd {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();
    private volatile int b = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {
            while(b!=0){
                zero.await();
            }
            printNumber.accept(0);
            if (i % 2 == 0) {
                b =2;
                even.signal();
            } else {
                b =1;
                odd.signal();
            }
        }
        lock.unlock();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i = i + 2) {
            while(b != 1){
                odd.await();
            }
            printNumber.accept(i);
            b=0;
            zero.signal();
        }
        lock.unlock();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 2; i <= n; i = i + 2) {
            while( b != 2){
                even.await();
            }
            printNumber.accept(i);
            b=0;
            zero.signal();
        }
        lock.unlock();
    }
}
// @lc code=end
