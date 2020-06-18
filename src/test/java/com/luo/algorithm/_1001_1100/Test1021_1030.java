package com.luo.algorithm._1001_1100;

import org.junit.Test;

public class Test1021_1030 {
    T1021_1030 t = new T1021_1030();

    @Test
    public void test1028() {
        System.out.println(t.recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(t.recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(t.recoverFromPreorder("1-401--349---90--88"));
    }
}
