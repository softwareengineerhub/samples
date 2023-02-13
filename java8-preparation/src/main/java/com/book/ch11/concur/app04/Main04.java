package com.book.ch11.concur.app04;

import java.util.concurrent.ThreadLocalRandom;

public class Main04 {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for(int i=0;i<10;i++) {
            int res = random.nextInt(0, 10);
            System.out.println(res);
        }
    }

}
