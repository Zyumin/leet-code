
/**
 * @author zhengyumin
 * @description ：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 *
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

  3
 / \
9  20
  /  \
 15   7
返回它的最大深度 3 。


 * @date 2020-07-24 6:17 PM
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left=treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        System.out.println(maxDepth(treeNode3));
    }


    private static int maxDepth(TreeNode treeNode) {

        if(treeNode==null){
            return 0;
        }
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);

        return Math.max(left,right)+1;

    }

}
