/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-03 3:15 PM
 */
public class DiameterOfBinaryTree {


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


        int ans = 0;
        new DiameterOfBinaryTree().dfs(treeNode3,ans);
        System.out.println(ans);



    }

    public int dfs(TreeNode root,int ans){

        if(root==null){
            return 0;
        }

        int l = dfs(root.left, ans);
        int r = dfs(root.right, ans);

        ans = Math.max(l+r,ans);

        return  Math.max(l,r)+1;





    }
}
