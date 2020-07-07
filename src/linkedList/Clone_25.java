package linkedList;

import java.util.HashMap;

/*
    复杂链表的复制
    题目描述
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
    另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone_25 {
    public RandomListNode clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = pHead;
        //第一次遍历 将复杂链表存入map，key：链表节点，value：节点对应的值
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }
        //第二次遍历 深拷贝链表，并赋值指针random的映射关系
        p = pHead;
        while(p != null){
            RandomListNode node = map.get(p);
            node.next = (p.next == null)?null: map.get(p.next);
            node.random = (p.random == null)?null: map.get(p.random);
            p = p.next;
        }
        //最后的返回值，返回拷贝后的头结点
        return map.get(pHead);
    }


    /*
     *第二种解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode clone1(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    public static void main(String[] args) {
        Clone_25 clone_25 = new Clone_25();
        RandomListNode pHead = new RandomListNode(1);
        pHead.next = new RandomListNode(2);
        pHead.next.next = new RandomListNode(3);
        pHead.next.next.next = new RandomListNode(4);
        pHead.next.next.next.next = new RandomListNode(5);
        pHead.random = new RandomListNode(3);
        pHead.next.random = new RandomListNode(5);
        pHead.next.next.next.next.random = new RandomListNode(2);
        RandomListNode head = clone_25.clone(pHead);
        System.out.println(head.label);
    }

}
