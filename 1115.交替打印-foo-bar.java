import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印FooBar
 */

// @lc code=start
class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition n1 =  lock.newCondition();
    private Condition n2 =  lock.newCondition();
    private volatile boolean b = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // one.acquire();
            lock.lock();
            if(!b){
                n1.await();
            }
            printFoo.run();
            // two.release();
            b = !b;
            n2.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            // two.acquire();
            if(b){
                n2.await();
            }
            printBar.run();
            // one.release();
            b=!b;
            n1.signal();
            lock.unlock();
        }
    }
}
// @lc code=end

