/**
 * @author zhengyumin
 * @description 一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，求：经过n步又回到0点有多少种不同的走法
 * @date 2020-10-21 11:15 AM
 */
public class Circle {


    public static void main(String[] args) {


        Circle demo = new Circle();
        System.out.println(demo.solution(10, 4));
    }


    /**
     * 动态规划
     * dp[k][j] = dp[k-1][j+1] + dp[k-1][j-1]
     *
     * @param n 环上点个数
     * @param k 步数
     * @return
     */
    public int solution(int n, int k) {

        //bad case
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return k%2==0?1:0;
        }

        int[][] dp = new int[k + 1][n];

        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % n] + dp[i - 1][(j - 1 + n) % n];
            }
        }

        // k步到0点的数量
        return dp[k][0];
    }
}
