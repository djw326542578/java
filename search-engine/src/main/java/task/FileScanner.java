package task;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileScanner {

    private ThreadPoolExecutor POOL = new ThreadPoolExecutor(3,3,0,TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy());

    public void scan(String path) {

    }
}
