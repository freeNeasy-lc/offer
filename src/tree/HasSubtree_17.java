package tree;
/*
树的子结构
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree_17 {
    //遍历大树
    public boolean HasSubtree(TreeNode_17 root1,TreeNode_17 root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        //如果找到与子树相同根的值，走判断方法
        if (root1.val == root2.val) {
            if (judge(root1, root2)) {
                return true;
            }
        }

        //遍历左孩子，右孩子
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //判断是否是子结构
    public boolean judge(TreeNode_17 root, TreeNode_17 subtree) {
        //子结构已经循环完毕，代表全部匹配
        if(subtree == null){
            return true;
        }

        //大树已经循环完毕，并未成功匹配
        if (root == null) {
            return false;
        }

        //相等后判断左右孩子
        if (root.val == subtree.val) {
            return judge(root.left, subtree.left) && judge(root.right, root.right);
        }
        return false;
    }
}
