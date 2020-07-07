package tree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树镜像
public class Mirror_18 {
    //递归
    public static void Mirror(TreeNode_18 root) {
        if (root == null) {
            return;
        }
        TreeNode_18 temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //非递归方法，利用二叉树的广度优先搜索
    //1. queue的增加元素方法add和offer的区别在于，
    // add方法在队列满的情况下将选择抛异常的方法来表示队列已经满了，
    // 而offer方法通过返回false表示队列已经满了；在有限队列的情况，使用offer方法优于add方法；
    //2. remove方法和poll方法都是删除队列的头元素，remove方法在队列为空的情况下将抛异常，
    // 而poll方法将返回null；
    public static void Mirror1(TreeNode_18 root) {
        if(root == null) return;
        //队列存的是TreeNode
        Queue<TreeNode_18> nodes = new LinkedList<>();
        TreeNode_18 curr, temp;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) nodes.offer(curr.left);
                if(curr.right != null) nodes.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode_18 root = new TreeNode_18(8);
        root.left = new TreeNode_18(6);
        root.right = new TreeNode_18(10);
        root.left.left = new TreeNode_18(5);
        root.left.right = new TreeNode_18(7);
        root.right.left = new TreeNode_18(9);
        root.right.right = new TreeNode_18(11);
        Mirror1(root);
        System.out.println(root);
    }
}
