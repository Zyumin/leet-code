/**
 * @author zhengyumin
 * @description No.300
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @date 2020-10-09 7:53 PM
 */
public class LengthOfLIS {


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }


        //init
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(dp[i], result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int []num = {10,9,2,5,3,7,101,18};

        LengthOfLIS demo = new LengthOfLIS();
        System.out.println(demo.lengthOfLIS(num));


    }


}
