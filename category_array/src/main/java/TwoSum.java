import java.util.Arrays;

/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/two-sum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @date 2020-07-13 5:29 PM
 */
public class TwoSum {


    /**
     * 解题思路
     * 方法一:使用hashMap存储
     * 方法二:双指针
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        int[] res = solution(nums, 9);
        System.out.println(res[0] + "," + res[1]);

    }

    /**
     * 使用双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums, int target) {

        int[] res = new int[2];
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int head = 0, tail = nums.length - 1;

        while (head < tail) {
            /**
             * 移动两个指针
             */
            if (nums[head] + nums[tail] < target) {
                head++;
                continue;
            }
            if (nums[head] + nums[tail] > target) {
                tail--;
                continue;
            }

            /**
             * 如果相等 则找到原索引
             */
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == nums[head]) {
                    res[0] = i;
                }
            }


            for (int i = temp.length - 1; i >= 0; i--) {
                if (temp[i] == nums[tail]) {
                    res[1] = i;
                }
            }
            break;
        }
        return res;
    }


}
