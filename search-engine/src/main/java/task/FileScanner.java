package task;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileScanner {

    public static class scan {

        private ThreadPoolExecutor POOL = new ThreadPoolExecutor(3,3,0,TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy());



    }
}
