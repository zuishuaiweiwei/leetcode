import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1117 lang=java
 *
 * [1117] H2O 生成
 */

// @lc code=start
class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(2);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException, BrokenBarrierException {
        h.acquire(1);
        releaseHydrogen.run();

        // o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException, BrokenBarrierException {
        cyc.await();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
// @lc code=end

