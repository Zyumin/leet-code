import java.util.HashMap;

/**
 * @author zhengyumin
 * @description todo 写点注释
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。


解法: 前缀和
 *
 * @date 2020-10-10 11:07 AM
 */
public class No560_SubarraySum {


    public static void main(String[] args) {

        No560_SubarraySum demo = new No560_SubarraySum();
//        int []nums = {1,1,1};
        int []nums = {3,4,7,2,-3,1,4,2};
        int k = 7;
        int count = demo.subArraySum2(nums,k);
        System.out.println(count);

    }


    public int subArraySum2(int []nums,int k){
        int count=0;
        if(nums.length==0){
            return count;
        }

        /**
         * 前缀和为key  次数为value
         */
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        /**
         * pre 前缀和  pre-k
         */
        int pre = 0;
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];

            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }

            map.put(pre,map.getOrDefault(pre,0)+1);
        }

        return count;
    }


    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int subArraySum(int []nums,int k){
        int count = 0;
        if(nums.length==0){
            return count;
        }

        for(int i = 0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){ count++;}
            }
        }

        return count;

    }
}
