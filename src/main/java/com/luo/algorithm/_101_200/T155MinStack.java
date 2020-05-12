package com.luo.algorithm._101_200;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T155MinStack {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public T155MinStack() {
    }

    public void push(int x){
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop(){
        Integer result = stack.pop();
        if(result == min){
            min = stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }

    //    private Integer[] value; // 保存最小值数组
//    private Integer[] minValue; // 容量
//    private int capacity = 10;
//    private int size = 0;   // 元素数量
//
//    public T155MinStack() {
//        value = new Integer[capacity];
//        minValue = new Integer[capacity];
//    }
//
//    /**
//     * 将元素x推入栈中
//     *
//     * @param x 元素
//     */
//    public void push(int x) {
//        if (size >= capacity) {
//            grow();
//        }
//        value[size] = x;
//        if (size == 0) {
//            minValue[size] = x;
//        } else if (minValue[size - 1] > x) {
//            minValue[size] = x;
//        } else {
//            minValue[size] = minValue[size - 1];
//        }
//        size++;
//    }
//
//    /**
//     * 删除栈顶的元素
//     */
//    public void pop() {
//        value[--size] = null;
//    }
//
//    /**
//     * 获取栈顶的元素
//     *
//     * @return 栈顶元素
//     */
//    public int top() {
//        return value[size - 1];
//    }
//
//    /**
//     * 检索栈中的最小元素
//     *
//     * @return 最小元素
//     */
//    public int getMin() {
//        return minValue[size - 1];
//    }
//
//    /**
//     * 扩容
//     */
//    private void grow() {
//        capacity *= 1.5;
//        Integer[] copy = new Integer[capacity];
//        Integer[] minCopy = new Integer[capacity];
//        System.arraycopy(value, 0, copy, 0, size);
//        System.arraycopy(minCopy, 0, minCopy, 0, size);
//        value = copy;
//        minValue = minCopy;
//    }
}
