
public class Trees {
    public static void preOrderTraversal(Node root){//打印前序遍历 递归方法实现
        if(root == null){
            return ;
        }

        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){//打印中序遍历 递归方法实现
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){//打印后序遍历 递归方法实现
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }


}
