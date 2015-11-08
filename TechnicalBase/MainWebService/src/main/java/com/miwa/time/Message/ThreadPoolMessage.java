package com.miwa.time.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMessage {

    private ExecutorService executor;

    public ThreadPoolMessage() {
        executor = Executors.newFixedThreadPool(10);
    }

    public void sendMessage(){
//        Runnable message = new SendMessage();
//        executor.execute(message);
    }
}
