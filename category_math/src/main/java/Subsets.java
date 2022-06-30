import java.util.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhengyumin
 * @description 子集、排列、组合
 * <p>
 * <p>
 * 子集
 * 比如输入 nums = [1,2,3]，你的算法应输出 8 个子集，包含空集和本身，顺序可以不同：
 * <p>
 * [ [],[1],[2],[3],[1,3],[2,3],[1,2],[1,2,3] ]
 * <p>
 * 组合
 * 比如输入 n = 4, k = 2，输出如下结果，顺序无所谓，但是不能包含重复（按照组合的定义，[1,2] 和 [2,1] 也算重复）：
 * <p>
 * [
 * [1,2],
 * [1,3],
 * [1,4],
 * [2,3],
 * [2,4],
 * [3,4]
 * ]
 * <p>
 * 排列
 * 比如说输入数组 [1,2,3]，输出结果应该如下，顺序无所谓，不能有重复：
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @date 2020-09-08 8:21 PM
 */
public class Subsets {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

//        s.backtrack(7,0,nums,track,result);

        Subsets s = new Subsets();
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> track = new ArrayList<>();


        int []nums =new int[]{2,3,6,7};
        s.subsets(nums,0,new LinkedList<>());
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }


    }



    public static class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            Deque<Integer> path = new ArrayDeque<>();
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param begin      搜索起点
         * @param len        冗余变量，是 candidates 里的属性，可以不传
         * @param target     每减去一个元素，目标值变小
         * @param path       从根结点到叶子结点的路径，是一个栈
         * @param res        结果集列表
         */
        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
            // target 为负数和 0 的时候不再产生新的孩子结点
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 重点理解这里从 begin 开始搜索的语意
            for (int i = begin; i < len; i++) {
                path.addLast(candidates[i]);

                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, i, len, target - candidates[i], path, res);

                // 状态重置
                path.removeLast();
            }
        }
    }

    public void backtrack(int target, int start,int[] nums, List<Integer> track, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(target - nums[i],i, nums, track, result);
            track.remove(track.size() - 1);
        }

    }

    /**
     * result = []
     * def backtrack(路径, 选择列表):
     * if 满足结束条件:
     * result.add(路径)
     * return
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(路径, 选择列表)
     * 撤销选择
     *
     * 子集
     */
    public void subsets(int[] nums, int start, LinkedList<Integer> track) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            subsets(nums, i + 1, track);
            track.removeLast();
        }
    }


    /**
     * 排列
     *
     * @param nums
     * @param track
     */
    public void permute(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            permute(nums, track);
            track.removeLast();
        }
    }


    /**
     * 组合
     *
     * @param nums
     * @param track
     */
    public void combine(int[] nums, int start, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            combine(nums, i + 1, track);
            track.removeLast();
        }
    }



}
