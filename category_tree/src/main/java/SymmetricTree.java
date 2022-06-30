import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-03 2:45 PM
 */
public class SymmetricTree {


    public static void main(String[] args) {


    }

    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) {return true;}
        if(root1==null||root2==null) {return false;}


        return root1.val==root2.val && isSymmetric(root1.left, root2.right)&&isSymmetric(root1.right, root2.left);
    }



    public boolean queue(TreeNode root){
        if(root==null){return true;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1==null&&t2==null) {continue;}
            if(t1==null||t2==null) {return false;}
            if(t1.val!=t2.val){ return false;}
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;

    }



}
