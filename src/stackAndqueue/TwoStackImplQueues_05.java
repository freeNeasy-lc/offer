package stackAndqueue;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。

import java.util.Stack;

//当插入时，直接插入 stack1
//当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
public class TwoStackImplQueues_05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int size() {
        int size = stack1.size() + stack2.size();
        return size;
    }
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        TwoStackImplQueues_05 twoStackImplQueues05 = new TwoStackImplQueues_05();
        int [] array = {1,2,4,5,7,8};
        for (int i = 0; i < array.length; i++) {
            twoStackImplQueues05.push(array[i]);
        }
        while(twoStackImplQueues05.size() > 0) {
            System.out.println(twoStackImplQueues05.pop());
        }
    }
}
