package task;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileScanner {

    //private ThreadPoolExecutor pool = new ThreadPoolExecutor(3,3,0,TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy());
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private  ScanCallback callback;

    public FileScanner(ScanCallback callback) {
        this.callback = callback;
    }


    public void scan(String path){
        doscan(new File(path));
    }
    private volatile AtomicInteger count = new AtomicInteger();
    private Object lock = new Object();


    public void doscan(File dir) {
        callback.callback(dir);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    File[] children = dir.listFiles();
                    if (children != null) {
                        for (File child : children) {
                            if (child.isDirectory()) {
                                //System.out.println("文件夹" + child.getPath());
                                count.incrementAndGet();
                                pool.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        doscan(child);
                                    }
                                });
                            }
                            // else {
                              //  System.out.println("文件" + child.getPath());
                            //}

                        }
                    }
                }finally {
                    int r = count.decrementAndGet();
                    if (r == 0){
                        synchronized (lock){
                            lock.notify();
                        }
                     }
                }
            }
        });
    }

    public void  waitFinish()throws InterruptedException{

        synchronized (lock){
            lock.wait();
        }

        shutdown();

    }

    //关闭线程池
    public void shutdown(){
        pool.shutdown();
        pool.shutdownNow();
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t2.start();
        t2.join();
        System.out.println(Thread.currentThread().getName());
    }
}
