import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @lc app=leetcode.cn id=1114 lang=java
 *
 * [1114] 按序打印
 */

// @lc code=start
class Foo {
    
    // private AtomicInteger one = new AtomicInteger(0);
    // private AtomicInteger two = new AtomicInteger(0);
    private Semaphore one = new Semaphore(0);
    private Semaphore two = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        printFirst.run();
        one.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        one.acquire();
        printSecond.run();
        two.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        two.acquire();
        printThird.run();
    }
}
// @lc code=end

