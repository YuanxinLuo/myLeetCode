package com.luo.interview;

import java.util.LinkedList;
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

    /**
     * 面试题 03.04. 化栈为队
     * 实现一个MyQueue类，该类用两个栈来实现一个队列。
     * <p>
     * 示例：
     * <p>
     * MyQueue queue = new MyQueue();
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     * <p>
     * 说明：
     * <p>
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     */
    class MyQueue {
        Stack<Integer> stackWriter;
        Stack<Integer> stackRead;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackWriter = new Stack<>();
            stackRead = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackWriter.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return stackRead.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!stackRead.isEmpty()) {
                return stackRead.peek();
            }
            while (!stackWriter.isEmpty()) {
                stackRead.push(stackWriter.pop());
            }
            return stackRead.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackRead.isEmpty() && stackWriter.isEmpty();
        }
    }


    /**
     * 面试题 03.06. 动物收容所
     * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
     * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
     * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
     * <p>
     * 示例1:
     * 输入：
     * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
     * [[], [[0, 0]], [[1, 0]], [], [], []]
     * 输出：
     * [null,null,null,[0,0],[-1,-1],[1,0]]
     * <p>
     * 示例2:
     * 输入：
     * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
     * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
     * 输出：
     * [null,null,null,null,[2,1],[0,0],[1,0]]
     */
    class AnimalShelf {

        private LinkedList<int[]> linkedList;

        public AnimalShelf() {
            this.linkedList = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            // 先进先出，将 animal 插入到双链表尾部
            linkedList.add(animal);
        }

        public int[] dequeueAny() {
            // 双链表为空
            if (linkedList.isEmpty()) {
                return new int[]{-1, -1};
            }
            // 非空，返回头结点的值并删除
            return linkedList.removeFirst();
        }

        public int[] dequeueDog() {
            int[] animal = {-1, -1};
            for (int i = 0; i < linkedList.size(); i++) {
                // 找到狗对应结点，返回结点值，并删除结点，结束循环
                if (linkedList.get(i)[1] == 1) {
                    animal = linkedList.get(i);
                    linkedList.remove(i);
                    break;
                }
            }
            // 未找到，返回 [-1, -1]
            return animal;
        }

        public int[] dequeueCat() {
            int[] animal = {-1, -1};
            for (int i = 0; i < this.linkedList.size(); i++) {
                // 找到猫对应结点，返回结点值，并删除结点，结束循环
                if (this.linkedList.get(i)[1] == 0) {
                    animal = this.linkedList.get(i);
                    this.linkedList.remove(i);
                    break;
                }
            }
            // 未找到，返回 [-1, -1]
            return animal;
        }
    }
}
