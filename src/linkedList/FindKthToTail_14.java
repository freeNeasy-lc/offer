package linkedList;

import java.util.ArrayList;

/*
输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail_14 {
    //双指针
    public static ListNode_14 FindKthToTail1(ListNode_14 head,int k) {
        ListNode_14 p1, p2;
        p1 = p2 = head;
        int i = 0;
        for (; p1 != null; i++) {
            //从第k步开始，第二个指针也从头指针开始遍历，两个指针距离始终保持在k-1
            //当第一个指针到达链表的尾结点时吗，第二个指针正好是倒数第k个节点
            if (i >= k)
                p2 = p2.next;
            p1 = p1.next;
        }
        return i < k ? null : p2;
    }
    public static ListNode_14 FindKthToTail(ListNode_14 head,int k) {
        int totalNum = 0;
        if(head != null){
            totalNum++;
        }else{
            return null;
        }
        // 计算总的节点数量
        ListNode_14 currentNode = head.next;
        while(currentNode != null){
            totalNum++;
            currentNode = currentNode.next;
        }

        if(totalNum < k){
            //throw new RuntimeException("k的值超过了链表长度");
            return null;
        }
        // 倒数第k个为正数第totalNum-k+1个
        ListNode_14 resultNode = head;
        for(int i=1; i<=totalNum-k; i++){
            resultNode = resultNode.next;
        }
        return resultNode;

    }
    public static void main(String[] args) {
        ListNode_14 root = new ListNode_14(1);
        root.next = new ListNode_14(2);
        root.next.next = new ListNode_14(3);
        root.next.next.next = new ListNode_14(4);
        root.next.next.next.next = new ListNode_14(5);
        ListNode_14 result = FindKthToTail1(root,2);
        System.out.println(result.val);
    }
}
