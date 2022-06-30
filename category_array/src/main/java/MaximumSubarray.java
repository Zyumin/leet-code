/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/maximum-subarray
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @date 2020-07-16 3:10 PM
 */
public class MaximumSubarray {


    /**
     * 解题思路：动规, 遍历，当 f(i) = Math.max(f(i-1)+ nums[i],nums[i]);
     *
     * @param args
     */
    public static void main(String[] args) {

        int []nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solutionV2(nums));

    }

//    public static int solution(int[] nums) {
//
//        //bad case
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int ans = 0, pre = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            pre = Math.max(pre + nums[i], nums[i]);
//            ans = Math.max(pre, ans);
//        }
//
//        return ans;
//
//    }



    public static int solutionV2(int []nums){
        if(nums.length==0){
            return 0;
        }
        int max = nums[0];
        int pre = 0;
        for(int i=0;i<nums.length;i++){
            pre = Math.max(nums[i],pre+nums[i]);
            max = Math.max(max,pre);
        }
        return max;

    }

//    public static int solution(int []nums){
//
//
//        if(nums.length==0){
//            return 0;
//        }
//
//        int max = nums[0];
//        int pre = 0;
//        for(int i=0;i<nums.length;i++){
//            pre = Math.max(nums[i],pre+nums[i]);
//            max = Math.max(max,pre);
//        }
//
//
//        return max;
//
//    }


}
