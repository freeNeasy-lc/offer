package tree;

import java.util.*;

/*
从上往下打印二叉树
从上往下打印出二叉树的每个节点，同层节点从左至右打印。(广度优先遍历)
 */
public class PrintFromTopToBottom_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode_22 root) {
        Deque<TreeNode_22> deque = new LinkedList<TreeNode_22>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        deque.add(root);

        while (!deque.isEmpty()) {
            //getFirst检索第一个元素
            TreeNode_22 node = deque.getFirst();
            //pollFirst检索并删除此deque的第一个元素，如果此deque为空，则返回 null 。
            deque.pollFirst();
            res.add(node.val);

            if (node.left != null) {
                //addLast在deque的末尾插入指定的元素
                deque.addLast(node.left);
            }

            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return res;
    }

    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode_22 root) {
        Queue<TreeNode_22> queue = new LinkedList<TreeNode_22>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode_22 node = queue.element();
            queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode_22 root = new TreeNode_22(8);
        root.left = new TreeNode_22(6);
        root.right = new TreeNode_22(10);
        root.left.left = new TreeNode_22(5);
        root.left.right = new TreeNode_22(7);
        root.right.left = new TreeNode_22(9);
        root.right.right = new TreeNode_22(11);
        PrintFromTopToBottom_22 pftt = new PrintFromTopToBottom_22();
        ArrayList<Integer> arrayList = pftt.PrintFromTopToBottom1(root);
        //ArrayList遍历
        System.out.println("1.for循环的遍历方式：");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("2.foreach的遍历方式：");
        for (Integer index : arrayList) {
            System.out.println(index);
        }
        System.out.println("3.Iterator的遍历方式：");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
