package com.tber.anzk.thread;

import com.tber.anzk.lock.DistributedLock;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author jianglu email:ansndx@163.com
 */
@Slf4j
public class ReadThreadDemo implements Runnable {

    private final DistributedLock lock;
    private final CountDownLatch latch;

    public ReadThreadDemo(DistributedLock lock,CountDownLatch latch) {
        this.lock = lock;
        this.latch = latch;
    }

    @Override
    public void run() {


        lock.acquire();
        log.info(Thread.currentThread().getName()+" read read read....ok");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.release();
        log.info(Thread.currentThread().getName()+" read release ok...");

        latch.countDown();
    }
}
