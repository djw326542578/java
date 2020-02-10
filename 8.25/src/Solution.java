import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class Solution {

    public static int calcHeight(TreeNode root){
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left,right)+1;
        return height;
    }

    public boolean isBalanced(TreeNode root){
        if (root.right == null && root.left == null){
            return true;
        }
        if (calcHeight(root.right)-calcHeight(root.left)<-1&&calcHeight(root.right)-calcHeight(root.left)>1){
            return false;
        }
        if (!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        return true;
    }

    public static boolean search(TreeNode root,TreeNode p){
        if (root == null){
            return false;
        }
        if (root == p){
            return true;
        }
        if (search(root.left,p)){
            return true;
        }
        return search(root.right,p);
    }

    public TreeNode lowestAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root == p || root == q){
            return root;
        }
        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        if (pInLeft&&qInLeft){
            return lowestAncestor(root.left,p,q);
        }
        if (!pInLeft&&!qInLeft){
            return lowestAncestor(root.right,p,q);
        }
        return root;
    }

    public static void levelOrder(TreeNode root){
        if (root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()){
            TreeNode front = queue.poll();
            if (front.left!= null){
                queue.add(front.left);
            }
            if (front.right!=null){
                queue.add(front.right);
            }
        }
    }
}
