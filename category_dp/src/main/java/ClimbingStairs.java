/**
 * @author zhengyumin
 * @description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

 * @date 2020-08-14 7:19 PM
 */
public class ClimbingStairs {
    public static void main(String[] args) {


        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {

        //dp[i] = dp[i-1]+dp[i-2]
        if(n<=2){
            return n;
        }

        int []dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=1;
        }
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    public int climbStairsV2(int n) {

        //dp[i] = dp[i-1]+dp[i-2]
        if(n<=2){
            return n;
        }

        int []dp= new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<n+1;n++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }





}
