package com.luo.interview;

import org.junit.Test;

public class Test03 {
    T03 t = new T03();

    @Test
    public void test0301() {
    }


    @Test
    public void test0304() {
        T03.MyQueue queue = t.new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
