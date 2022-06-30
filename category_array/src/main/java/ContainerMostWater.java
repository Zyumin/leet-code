/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * @date 2020-07-14 6:51 PM
 */
public class ContainerMostWater {


    /**
     * 解题思路:
     * 双指针头尾缩减（小的移动）,计算最大面积
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        //bad case
        if (nums.length == 0) {
            return 0;
        }

        int head = 0, tail = nums.length - 1;

        int ans = 0;
        while (head < tail) {

            ans = Math.max(ans, Math.min(nums[head], nums[tail]) * (tail - head));

            if (nums[head] < nums[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return ans;
    }
}
