/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-11 12:28 AM
 */
public class Dfs {

    /**
     *       1
            / \
          2   5
         / \   \
        3   4   6

     * 前序 1、2、3、4、5、6    (中左右)
     * 中序 3、2、4、1、5、6    (左中右)
     * 后序 3、4、2、6、5、1    (左右中)
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode nnode2 = new TreeNode(2);
        TreeNode nnode3 = new TreeNode(3);
        TreeNode nnode4 = new TreeNode(4);
        TreeNode nnode5 = new TreeNode(5);
        TreeNode nnode6 = new TreeNode(6);

        root.left = nnode2;
        root.right=nnode5;
        nnode2.left=nnode3;
        nnode2.right=nnode4;
        nnode5.right=nnode6;


        dfs(root);
    }

    /**
     * 前序 1、2、3、4、5、6
     * 中序 3、2、4、1、5、6
     * 后序 3、4、2、6、5、1
     * @param root
     */
    public static void dfs(TreeNode root) {
        if(root==null)return;



        dfs(root.left);
        dfs(root.right);
        System.out.println(root.val);

    }
}
