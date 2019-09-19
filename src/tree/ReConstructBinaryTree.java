package tree;


import tree.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
//              1
//           /     \
//          2       3
//         /       / \
//        4       5   6
//         \         /
//          7       8
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,
                                           int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i=startIn;i <= endIn; i++) {
            if (in[i]==pre[startPre]) {
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }

        return root;
    }

    //前序遍历二叉树，根——左——右
    public void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            //字符和字符串的区别
            //" " 输出内容为空格的字符串；' ' 输出空格字符对应的ACCII码
            //""双引号是字符串，可以把数字连接成字符串
            //'' 单引号是字符，空格的ascii码是32，与之前的数字相加求和
            //System.out.print(treeNode.val + ' ');
            System.out.print(treeNode.val + " ");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    //中序遍历二叉树，左——根——右
    public void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.print(treeNode.val + " ");
            inOrder(treeNode.right);
        }
    }

    //后序遍历二叉树,左——右——根
    public void postOrder(TreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree rcbt = new ReConstructBinaryTree();
        TreeNode root = rcbt.reConstructBinaryTree(pre,in);
        //1 2 4 7 3 5 6 8
        rcbt.preOrder(root);
        //4 7 2 1 5 3 8 6
        rcbt.inOrder(root);
        //7 4 2 5 8 6 3 1
        rcbt.postOrder(root);
    }
}
