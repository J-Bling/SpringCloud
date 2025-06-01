package com.consumer.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class GetInstancsTest {

    @Autowired private ServiceInstanceChooser serviceInstanceChooser;

    private int size = 0;

    public synchronized void count(int port){
        if(port==8001) this.size++;
        System.out.println(this.size);
    }

    @Test
    public void test() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

        for(int i=0 ; i<=10;i++){
            executor.execute(()->{
                ServiceInstance instance= serviceInstanceChooser.choose("productor");
                count(instance.getPort());
            });
        }

        Thread.sleep(120*1000);
    }
}
