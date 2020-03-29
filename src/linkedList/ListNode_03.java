package linkedList;

public class ListNode_03 {
    //java里的node没有指针的概念，是引用，实际上就是一个地址
    //ListNode next就是指向链表的下一个节点
    //ListNode next = null，新建一个null节点，说明初始化了一个空链表。
    ListNode_03 next = null;
    //ListNode next = new ListNode(2);
    //val记录节点数据
    int val;
    ListNode_03(int val) {
        this.val = val;
    }
}
