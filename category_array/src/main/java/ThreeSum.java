import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/3sum
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @date 2020-07-13 6:14 PM
 */
public class ThreeSum {


    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0};
        solution(nums).stream().forEach(a -> {
            a.stream().forEach(b -> System.out.print(b + ","));
            System.out.println("");
        });

    }

    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> solution(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSolution(nums, i + 1, nums.length - 1, -nums[i]);

        }

        return ans;
    }

    /**
     * twoSolution
     *
     * @param nums
     * @param target
     * @return
     */
    public static void twoSolution(int[] nums, int head, int tail, int target) {

        while (head < tail) {
            if (nums[head] + nums[tail] == target) {
                ans.add(Lists.newArrayList(-target, nums[head], nums[tail]));

                while (head < tail && nums[head] == nums[head + 1]) {
                    head++;
                }
                head++;

                while (head < tail && nums[tail] == nums[tail - 1]) {
                    tail--;
                }
                tail--;
                continue;
            }


            if (nums[head] + nums[tail] < target) {
                head++;
                continue;
            }

            if (nums[head] + nums[tail] > target) {
                tail--;
                continue;
            }


        }
    }

}
