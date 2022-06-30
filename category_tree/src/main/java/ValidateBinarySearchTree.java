/**
 * @author zhengyumin
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *       / \
 *      3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020-08-12 9:15 PM
 */
public class ValidateBinarySearchTree {

    /**
     * 中序遍历 判断大小
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);


        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;


        solution(treeNode3);

    }

    static int pre = Integer.MIN_VALUE;

    private static void solution(TreeNode treeNode3) {

        System.out.println(dfs(treeNode3));
    }

    private static boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean l = dfs(node.left);

        if (node.val <= pre) {
            return false;
        }
        pre = node.val;


        boolean r = dfs(node.right);

        return l && r;
    }


}
