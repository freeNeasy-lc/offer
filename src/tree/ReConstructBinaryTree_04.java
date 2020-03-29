package tree;


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
public class ReConstructBinaryTree_04 {
    public TreeNode_04 reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode_04 root =reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    /**
     *
     * @param pre       前序遍历
     * @param startPre  前序遍历的开始位置，startPre = 0
     * @param endPre    前序遍历的结束位置，初始值pre.length-1
     * @param in        中序遍历
     * @param startIn   中序遍历的开始位置，startIn = 0
     * @param endIn     中序遍历的结束位置，初始值in.length-1
     * @return          树的根结点
     */
    private TreeNode_04 reConstructBinaryTree(int [] pre,int startPre,int endPre,
                                           int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        // 取前序第一个数字，就是当前根节点
        TreeNode_04 root = new TreeNode_04(pre[startPre]);
        // 在中序中找到前序的根
        for (int i=startIn;i <= endIn; i++) {
            if (in[i]==pre[startPre]) {
                // 递归构建当前根结点的左子树，左子树的元素个数：i-startIn+1个
                // 左子树对应的前序遍历的位置在[startPre+1,startPre+i-startIn]
                // 左子树对应的中序遍历的位置在[startIn, i-1]
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                // 递归构建当前根结点的右子树，右子树的元素个数：endPre-i个
                // 右子树对应的前序遍历的位置在[i-startIn+startPre+1, endPre] 根节点(startPre) + 左子树(i-startIn+1)
                // 右子树对应的中序遍历的位置在[i+1, endIn]
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }

        return root;
    }

    //前序遍历二叉树，根——左——右
    public void preOrder(TreeNode_04 treeNode) {
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
    public void inOrder(TreeNode_04 treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.print(treeNode.val + " ");
            inOrder(treeNode.right);
        }
    }

    //后序遍历二叉树,左——右——根
    public void postOrder(TreeNode_04 treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.val + " ");
        }
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree_04 rcbt = new ReConstructBinaryTree_04();
        TreeNode_04 root = rcbt.reConstructBinaryTree(pre,in);
        System.out.println(root);
        //1 2 4 7 3 5 6 8
        rcbt.preOrder(root);
        //4 7 2 1 5 3 8 6
        rcbt.inOrder(root);
        //7 4 2 5 8 6 3 1
        rcbt.postOrder(root);
    }
}
