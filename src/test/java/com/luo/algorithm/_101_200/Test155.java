package com.luo.algorithm._101_200;

import org.junit.Test;

public class Test155 {
    @Test
    public void test155() {
        int[][] testTable = {{1,-2,3},{2,7,9,-3,1},{7,10,4,3,1},{11,6,2,7}};
        for (int[] ito : testTable) {
            test(ito);
        }
    }

    private void test(int[] ito) {
        T155MinStack solution = new T155MinStack();
        int rtn;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < ito.length; i++) {
            System.out.print(ito[i]+" ");
            solution.push(ito[i]);
        }
        System.out.println();
        //开始时打印数组

        rtn = solution.top();//执行程序
        long end = System.currentTimeMillis();

        System.out.println(": rtn=" +rtn);


        rtn = solution.getMin();//执行程序

        System.out.println(": rtn=" +rtn);

        System.out.println();
        System.out.println("耗时：" + (end - begin) + "ms");
        System.out.println("-------------------");
    }

}
