package com.luo.interview;

import java.util.Stack;

public class T03 {
    /**
     * 面试题 03.01. 三合一
     * 三合一。描述如何只用一个数组来实现三个栈。
     * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
     * 构造函数会传入一个stackSize参数，代表每个栈的大小。
     * 示例1:
     * 输入：
     * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
     * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
     * 输出：
     * [null, null, null, 1, -1, -1, true]
     * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
     * 示例2:
     * 输入：
     * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
     * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
     * 输出：
     * [null, null, null, null, 2, 1, -1, -1]
     */
    class TripleInOne {
        int[] arr = {};
        int[] size = {};
        int stackSize;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            arr = new int[3 * stackSize];
            size = new int[]{0, 0, 0};
        }

        public void push(int stackNum, int value) {
            int len = size[stackNum];
            if (len < stackSize) {
                arr[stackNum * stackSize + len] = value;
                size[stackNum] = len + 1;
            }
        }

        public int pop(int stackNum) {
            int topVal = peek(stackNum);
            if (size[stackNum] > 0) {
                size[stackNum] -= 1;
            }
            return topVal;
        }

        public int peek(int stackNum) {
            if (size[stackNum] == 0) return -1;
            return arr[stackNum * stackSize + size[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }

    /**
     * 面试题 03.02. 栈的最小值
     * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
     * 示例：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public MinStack() {
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            Integer result = stack.pop();
            if (result == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
