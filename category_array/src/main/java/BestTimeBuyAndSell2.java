import java.util.HashMap;
import java.util.Map;

/**
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 可以多次买卖
 */
public class BestTimeBuyAndSell2 {

    public static void main(String[] args) {
        BestTimeBuyAndSell2 demo = new BestTimeBuyAndSell2();

        // 4 3
        int[] num = {7, 1, 5, 3, 6, 4};

        System.out.println(demo.solution3(num));

    }

    public int maxProfit(int[] num) {

        int len = num.length;
        if (len < 2) {
            return 0;
        }
//        return dfs(num, 0, 0);

//        Map<String,Integer> map = new HashMap<String,Integer>();
//
//
//        return dfsMemo(map,num, 0, 0);

        return solution3(num);
    }



    /**
     * 方法一、暴力回溯
     *
     * @param num
     * @param index
     * @param status
     */
    public int dfs(int[] num, int index, int status) {

        if (index == num.length) {
            return 0;
        }

        //不做操作 ,买,卖
        int a=0, b=0,c = 0;
        a = dfs(num, index + 1, status);
        if (status==0) {
             b = dfs(num, index + 1, 1)- num[index];
        } else {
             c = dfs(num, index + 1, 0)+ num[index];
        }

        return Math.max(Math.max(a,b),c);
    }

    /**
     * 带备忘录
     *
     * @param map
     * @param num
     * @param index
     * @param status
     * @return
     */
    public int dfsMemo(Map<String, Integer> map, int[] num, int index, int status) {

        if (index == num.length) {
            return 0;
        }

        String key = index+","+status;
        if(map.containsKey(key)){
            return map.get(key);
        }

        //不做操作,买,卖
        int a=0, b=0,c = 0;
        a = dfsMemo(map, num, index + 1, status);
        if (status==0) {
            b = dfsMemo(map, num, index + 1, 1)- num[index];
        } else {
            c = dfsMemo(map, num, index + 1, 0)+ num[index];
        }

        map.put(key,Math.max(Math.max(a,b),c));
        return map.get(key);
    }



    /**
     * 贪心 只加向上
     */
    public int solution2(int[] num) {

        int profit = 0;
        for (int i = 0; i < num.length - 1; i++) {
            profit += Math.max(num[i + 1] - num[i], 0);
        }
        return profit;

    }

    /**
     * 动态规划
     * @param num
     * @return
     */
    public int solution3(int []num){

        /**
         * dp [i] 表示 第i天
         * dp[i][0] 持有现金
         * dp[i][1] 持有股票
         */
        int [][]dp = new int [num.length][2];

        //bad case
        dp[0][0] = 0;
        dp[0][1] = -num[0];

        for (int i = 1; i < num.length; i++) {
            //继续保持or卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+num[i]);
            //继续保持or买入
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-num[i]);
        }

        //最后日期返回持有现金
        return dp[num.length-1][0];

    }

    /**
     * 二维数组 可以优化,观察可得只和前一个变量相关
     * @param num
     * @return
     */
    public int solution3Optimization(int []num){

        return 0;
    }

}



