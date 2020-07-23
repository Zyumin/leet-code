/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

 * @date 2020-07-14 8:27 PM
 */
public class TrappingRainWater {


    /**
     * 解题思路:
     *  分别左右遍历一遍，找到i的最大左视图，和右视图
     *  再遍历一遍，用左右最大视图中的小值 减去高度 即为当前盛水容量
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution(nums));

    }

    public static int solution(int[] nums){

        int []leftMax = new int[nums.length];
        int []rightMax = new int[nums.length];

        leftMax[0] = nums[0];


        for(int i =1;i<nums.length-1;i++){
            leftMax[i] = Math.max(leftMax[i-1],nums[i]);
        }

        rightMax[nums.length-1] = nums[nums.length-1];
        for(int i =nums.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],nums[i]);

        }

        int ans= 0;
        for(int i =0;i<nums.length-1;i++){
            ans+= Math.min(rightMax[i],leftMax[i])-nums[i];
        }


        return ans;
    }


}
