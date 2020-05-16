package com.luo.algorithm._1101_1200;

public class T1101_1110 {
    /**
     * 1108. IP 地址无效化
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     * 示例 1：
     *
     * 输入：address = "1.1.1.1"
     * 输出："1[.]1[.]1[.]1"
     * 示例 2：
     *
     * 输入：address = "255.100.50.0"
     * 输出："255[.]100[.]50[.]0"
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".","[.]"); // 执行用时 0ms 内存37.2m
//        return address.replaceAll("\\.","[.]");           // 执行用时 3ms  内存 37.9m
    }
}
