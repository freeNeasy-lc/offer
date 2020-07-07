package linkedList;

/*
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge_16 {
    public static ListNode_16 Merge(ListNode_16 list1,ListNode_16 list2) {
        ListNode_16 head = new ListNode_16(-1);
        ListNode_16 cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1!=null) cur.next = list1;
        if (list2!=null) cur.next = list2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode_16 list1 = new ListNode_16(1);
        list1.next = new ListNode_16(3);
        list1.next.next = new ListNode_16(5);
        list1.next.next.next = new ListNode_16(7);
        ListNode_16 list2 = new ListNode_16(2);
        list2.next = new ListNode_16(4);
        list2.next.next = new ListNode_16(6);
        list2.next.next.next = new ListNode_16(8);
        ListNode_16 merge = Merge(list1, list2);
        System.out.println(merge.val);
    }
}
