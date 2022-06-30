/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-01 7:58 PM
 */
public class PredictTheWinner {

    static int[][]mono;
    public static void main(String[] args) {


        int[] input = {1, 5, 233, 7};
        mono = new int[input.length][input.length];


        boolean isWin = dp(input);
        System.out.println(isWin);

    }


    public static boolean dp(int[] nums){

        int length = nums.length;

        int dp[][] = new int[length][length];
        //bad case
        for(int i=0;i<length;i++){
            dp[i][i] = nums[i];
        }


        for(int i=length-2;i>=0;i--){
            for(int j=i+1;j<length;j++){
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }

        return dp[0][length-1]>=0;


    }


    private static boolean solution(int[] input) {

        //
        return dfs(input, 0, input.length-1) >= 0;


    }




    private static int dfs(int[] input, int i, int j) {

        //bad case
        if (i == j) {
            mono[i][i] = input[i];
            return mono[i][i];
        }
        if(mono[i][j]!=0){
            return mono[i][j];
        }

        int pickI = input[i] - dfs(input, i + 1, j);
        int pickJ = input[j] - dfs(input, i, j - 1);
        mono[i][j] = Math.max(pickI,pickJ);

        return mono[i][j];


    }
}
