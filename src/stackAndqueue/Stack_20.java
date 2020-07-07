package stackAndqueue;

import java.util.Stack;

/*
包含min函数的栈
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
//peek() 查看此堆栈顶部的对象。
public class Stack_20 {
    Stack<Integer> stackTotal = new Stack<Integer>();
    Stack<Integer> stackLittle = new Stack<Integer>();
    public void push(int node) {
        stackTotal.push(node);
        if (stackLittle.isEmpty()) {
            stackLittle.push(node);
        }else {
            if (node <= stackLittle.peek()) {
                stackLittle.push(node);
            }else {
                stackLittle.push(stackLittle.peek());
            }
        }
    }

    public void pop() {
        stackTotal.pop();
        stackLittle.pop();
    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackLittle.peek();
    }

    public static void main(String[] args) {
        Stack_20 stack_20 = new Stack_20();
        int[] array = {3,4,2,1};
        for (int i=0; i<array.length; i++) {
            stack_20.push(array[i]);
        }
        int min = stack_20.min();
        System.out.println(min);
        stack_20.pop();
        int min1 = stack_20.min();
        System.out.println(min1);
        int top = stack_20.top();
        System.out.println(top);
    }
}
