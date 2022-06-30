import java.util.HashMap;

/**
 * @author zhengyumin
 * @description
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。

 * @date 2020-10-10 5:06 PM
 */
public class FindTargetSumWays {

    int count=0;
    public static void main(String[] args) {

        int []nums = {1,1,1,1,1};
        int s = 3;
        FindTargetSumWays demo = new FindTargetSumWays();
        System.out.println(demo.findTargetSumWays(nums,s));
    }

    private void caculate(int nums[],int i,int ret){
        if(i==nums.length){
            if(ret==0){ count++;}
        }else{
            caculate(nums,i+1,ret+nums[i]);
            caculate(nums,i+1,ret-nums[i]);
        }

    }



    private int caculateMomo(HashMap<String,Integer> map,int nums[], int i, int ret){
        if(i==nums.length){
            if(ret==0){ return 1;}
            return 0;
        }else {
            String key = i + "," + ret;
            if (map.containsKey(key)) {
                return map.get(key);
            }

            int d = caculateMomo(map, nums, i + 1, ret + nums[i]) + caculateMomo(map, nums, i + 1, ret - nums[i]);

            map.put(key, d);
            return map.get(key);
        }
    }


    /**
     *
     * @param nums
     * @param s
     * @return
     */
    private int findTargetSumWays(int nums[],int s){
        caculate(nums,0,s);

//        return caculateMomo(new HashMap<String, Integer>(),nums,0,s);
        return count;
    }


}
