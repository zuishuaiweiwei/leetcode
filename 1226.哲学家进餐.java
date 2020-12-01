import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1226 lang=java
 *
 * [1226] 哲学家进餐
 */

// @lc code=start
class DiningPhilosophers {
    private Semaphore[] lockList = new Semaphore[] { new Semaphore(1), new Semaphore(1), new Semaphore(1),
            new Semaphore(1), new Semaphore(1) };

    private Semaphore punish = new Semaphore(1);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        while (true) {
            if (lockList[philosopher % 5].tryAcquire()) {
                if (lockList[(philosopher + 1) % 5].tryAcquire()) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();

                    lockList[philosopher % 5].release();
                    lockList[(philosopher + 1) % 5].release();
                    punish.release();
                    break;
                }else{
                    lockList[philosopher % 5].release();
                }
            }
                punish.acquire();
        }
    }
}
// @lc code=end
