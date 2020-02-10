import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class test{
    //计算二叉树的结点个数
    public static int countTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = countTree(root.left);
        int right = countTree(root.right);
        return  left+ right + 1;
    }
    //计算叶子结点个数
    public static int leafcount = 0;
    public static int calcLeaf(TreeNode root){
        if (root == null){
            return 0;
        }
        calcLeaf(root.left);
        if (root.left == null&&root.right == null){
            leafcount++;
        }
        calcLeaf(root.right);
        return leafcount;
    }

    //计算二叉树的高度
    public static int calcHeight(TreeNode root){
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int heght = Math.max(left,right)+1;
        return heght;
    }
    //计算二叉树第K层的结点个数
    public static int calcLevel(TreeNode root, int k){
        if (root == null){
            return 0;
        }

        if (k == 1){
            return 1;
        }
        int left = calcLevel(root.left,k-1);
        int right = calcLevel(root.right,k-1);
        return left+right;
    }
    //查找
     public static TreeNode search(TreeNode root,int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = search(root.left, val);
        if (left!=null){
            return left;
        }
        TreeNode right = search(root.right, val);
       if (right!= null){
           return right;
       }
       return null;
    }
    //查找
    public static boolean Search(TreeNode root,int val){
        if (root == null){
            return false;
        }
        if (root.val == val){
            return true;
        }
        if (Search(root.left,val)){
            return true;
        }
        return Search(root.right,val);
    }
        //判断相同的树

        //判断镜像树
     public static boolean isMirror(TreeNode p,TreeNode q){
       if (p==null  &&  q==null){
           return true;
       }

       if (p==null||q==null){
           return false;
       }
        return p.val==q.val
                && isMirror(p.right,q.left)
                && isMirror(p.left,q.right);
     }
     //判断对称树
    public static boolean isSymmetrical(TreeNode root){
        if (isMirror(root.right,root.left)){
            return true;
        }
        return false;
    }

}