/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/first-missing-positive
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * @date 2020-08-06 3:17 PM
 */
public class FirstMissingPositive {


    public static void main(String[] args) {
        int[] case1 = new int[]{1, 2, 0};
        int[] case2 = new int[]{3, 4, -1, 1};
        int[] case3 = new int[]{7, 8, 9, 11, 12};

        System.out.println("case1:" + solution(case1));
        System.out.println("case2:" + solution(case2));
        System.out.println("case3:" + solution(case3));
    }

    private static int solution(int[] nums) {
        int n = nums.length;
        //将负数变为n+1
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //将1—n的打上负数标记
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //返回第一个大于0的
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


}
