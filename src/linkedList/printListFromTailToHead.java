package linkedList;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
*/

public class printListFromTailToHead {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    //递归实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    //借助堆栈后进先出实现
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String args[]) {
        printListFromTailToHead p = new printListFromTailToHead();
        printListFromTailToHead p1 = new printListFromTailToHead();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        ArrayList<Integer> arrayList1 = p1.printListFromTailToHead1(root);
        ArrayList<Integer> arrayList = p.printListFromTailToHead(root);
        System.out.println("arrayList:"+arrayList+",arrayList1"+arrayList1);
    }
}
