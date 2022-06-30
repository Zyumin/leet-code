/**
 * @author zhengyumin
 * @description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @date 2020-07-13 6:57 PM
 */
public class BestTimeBuyAndSell {

    /**
     *
     * 系列文章:
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/wu-chong-shi-xian-xiang-xi-tu-jie-121-mai-mai-gu-p/
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
//        int[] nums = new int[]{7, 6, 4, 3, 1};

        System.out.println(solution(nums));

    }

    public static int solution(int[] nums) {

        //bad case
        int[] dp = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            dp[i] = min;
        }

        //dp = {7,1,1,1,1,1}

        int profit = 0;
        for (int i = 0; i < nums.length; i++) {
            profit = Math.max(profit, nums[i] - dp[i]);
        }
        return profit;
    }



}
