import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _105_BT_from_In_And_Pre {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return constructTree(0, 0, preorder.length - 1, preorder, inorder, inMap);
    }

    public TreeNode constructTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,
                                  HashMap<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        root.left = constructTree(preStart + 1, inStart, inRoot - 1, preorder, inorder, inMap);
        root.right = constructTree(preStart + inRoot - inStart + 1, inRoot + 1, inEnd, preorder,
                inorder, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};

        TreeNode head = new _105_BT_from_In_And_Pre().buildTree(pre, in);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            if (tn != null) {
                System.out.print(tn.val + ",");
                q.add(tn.left);
                q.add(tn.right);
            } else {
                System.out.print("null" + ",");
            }
        }
    }
}
