package com.diycomputerscience.webhog;

public class DeadlockTest {
   private static long sleepMillis;
   private final Object lock1 = new Object();
   private final Object lock2 = new Object();
 
   public static void main(String[] args) {
       sleepMillis = 1; //Long.parseLong(args[0]);
       DeadlockTest test = new DeadlockTest();
       test.doTest();
   }
 
   private void doTest() {
       Thread t1 = new Thread(new Runnable() {
           public void run() {
               lock12();
           }
       });
       Thread t2 = new Thread(new Runnable() {
           public void run() {
               lock21();
           }
       });
       t1.start();
       t2.start();
   }
 
   private void lock12() {
       synchronized (lock1) {
           sleep();
           synchronized (lock2) {
               sleep();
           }
       }
   }
 
   private void lock21() {
       synchronized (lock2) {
           sleep();
           synchronized (lock1) {
               sleep();
           }
       }
   }
 
   private void sleep() {
       try {
           Thread.sleep(sleepMillis);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}