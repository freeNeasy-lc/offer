package linkedList;

/*
    输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList_15 {
    public static ListNode_15 ReverseList(ListNode_15 head) {
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode_15 pre = null;
        //初始化p指针，用于记录当前结点的下一个结点地址
        ListNode_15 p = null;
        //head指向null时，循环终止
        while (head != null) {
            //先用p指针记录当前结点的下一个结点地址。
            p = head.next;
            //让被当前结点与链表断开并指向前一个结点pre
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向p(保存着原链表中head的下一个结点地址)
            head = p;
        }
        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }

    public static void main(String[] args) {
        ListNode_15 root = new ListNode_15(1);
        root.next = new ListNode_15(2);
        root.next.next = new ListNode_15(3);
        root.next.next.next = new ListNode_15(4);
        root.next.next.next.next = new ListNode_15(5);
        ListNode_15 result = ReverseList(root);
        System.out.println(result.val);
    }
}
