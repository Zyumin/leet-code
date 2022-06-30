import java.util.Arrays;

/**
 * @author zhengyumin
 * @description
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1


 * @date 2020-10-12 5:50 PM
 */
public class No322_Coin {

      int result = Integer.MAX_VALUE;

    int []memo;
    /**
     * 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
//        return backTrack(coins,amount);
//        backTrack(coins, amount,0);

        memo = new int[amount+1];

        return backTrackWithMemo(coins, amount);
    }


    /**
     * 回溯框架 ——>无需关注路径
     * @param nums
     * @param amount
     */
    public void backTrack(int []nums, int amount,int count){
        if(amount<0){
            return;
        }
        if(amount==0){
            result = Math.min(result,count);
            return ;
        }

        for(int i=0;i<nums.length;i++){
            backTrack(nums,amount-nums[i],count+1);
        }

    }

    /**
     * 回溯框架 ——>无需关注路径
     * @param nums
     * @param amount
     */
    public int backTrack(int []nums, int amount){
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sub = backTrack(nums,amount-nums[i]);
            if(sub==-1){
                continue;
            }else{
                min = Math.min(min,1+sub);
            }
        }

        return min;
    }

    public int backTrackWithMemo(int []nums, int amount){
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }

        if(memo[amount]!=0){
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sub = backTrackWithMemo(nums,amount-nums[i]);
            if(sub!=-1){
                min = Math.min(min,1+sub);
            }
        }

        memo[amount] = (min==Integer.MAX_VALUE?-1:min);

        return memo[amount];
    }

    public int dp(int []nums, int amount){

        int []memo = new int[amount+1];
        Arrays.fill(memo,amount+1);


        //fixme
        return 0;




    }



    public static void main(String[] args) {
        No322_Coin demo  = new No322_Coin();

        int []nums = {2};
        int target = 3;
        System.out.println( demo.coinChange(nums,target));
    }
}
