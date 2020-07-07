package tree;

import java.util.ArrayList;

/*
    二叉搜索树与双向链表
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert_26 {

    public TreeNode_26 Convert(TreeNode_26 pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        ArrayList<TreeNode_26> list=new ArrayList<>();
        Convert(list,pRootOfTree);
        return Convert(list);
    }

    //中序遍历
    public void Convert(ArrayList<TreeNode_26> list,TreeNode_26 root){
        if (root!=null){
            Convert(list,root.left);
            list.add(root);
            Convert(list,root.right);
        }
    }

    public TreeNode_26 Convert(ArrayList<TreeNode_26> list){
        TreeNode_26 head=list.get(0);
        TreeNode_26 cur=head;
        for (int i=1;i< list.size();++i){
            TreeNode_26 node=list.get(i);
            node.left=cur;
            cur.right=node;
            cur=node;
        }
        return head;
    }
}
