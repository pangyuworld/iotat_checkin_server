package com.pang.card;

import org.junit.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ThreadTest
 * @Package com.pang.card
 * @description:
 * @date 2019/10/31 18:37
 */
public class ThreadTest {
    private static final int ATC = Thread.activeCount();

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j=0;j<20;j++){
                    System.out.println(Thread.currentThread().getName()+" "+j);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println();
        while(Thread.activeCount() > ATC){}
    }
    @Test
    public void threadTest(){

    }
}
