package traversal;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode root = new TreeNode(1, two, five);


        System.out.println(traverse("inorder", root)); //expected 3,2,4,1,5
        System.out.println(traverse("preorder", root)); //expected 1,2,3,4,5
        System.out.println(traverse("postorder", root)); //expected 3,4,2,5,1
    }

    private static List<Integer> traverse(String type, TreeNode root) {
        List<Integer> list = new LinkedList<>();
        switch (type.toLowerCase()){
            case "inorder":
                inOrderTraversal(root, list);
                return list;
            case "preorder":
                preOrderTraversal(root, list);
                return list;
            case "postorder":
                postOrderTraversal(root, list);
                return list;
            default:
                System.out.println("wrong type!");
                return null;
        }
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
    private static void preOrderTraversal(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    private static void postOrderTraversal(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.val);
    }
}
