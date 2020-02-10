import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}


public class Solution{
    private List<Integer> list;
   /* public List<Integer> preorderTraversal(TreeNode root){//前序遍历返回二叉树
        if (root == null){
            return new ArrayList<>();//如果返回Null可能在递归过程中报错，所有返回一个空的线性表
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> leftPreorder = preorderTraversal(root.left);
        List<Integer> rightPreorder = preorderTraversal(root.right);

        list.add(root.val);
        list.addAll(leftPreorder);
        list.addAll(rightPreorder);

        return list;
    }*/
    //方法二


    private void proOrder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        proOrder(root.left);
        proOrder(root.right);
    }

    public List<Integer> proordertraversal(TreeNode root){
        list = new ArrayList<>();
        proOrder(root);
        return list;
    }
}
