package tree;

import java.util.ArrayList;

/*
    二叉树中和为某一值的路径
    输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath_24 {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode_24 root, int target) {
        if(root == null)
            return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return result;
    }

    public static void main(String[] args) {
        FindPath_24 fp = new FindPath_24();
        TreeNode_24 root = new TreeNode_24(8);
        root.left = new TreeNode_24(6);
        root.right = new TreeNode_24(10);
        root.left.left = new TreeNode_24(5);
        root.left.right = new TreeNode_24(7);
        root.right.left = new TreeNode_24(1);
        root.right.right = new TreeNode_24(11);
        int target = 19;
        ArrayList<ArrayList<Integer>> lists = fp.FindPath(root, target);
        for (ArrayList<Integer> list : lists) {
            System.out.println("------------");
            for (Integer val : list)
                System.out.println(val);
        }
    }
}
