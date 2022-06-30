import java.util.Arrays;

/**
 * @author zhengyumin
 * @description todo 写点注释
 *
 * 示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4


 * @date 2020-10-20 4:28 PM
 */
public class SingleNumber {


    public static void main(String[] args) {

        int []nums = {1,2,1,4,3,3,2};


        SingleNumber demo = new SingleNumber();

        System.out.println(demo.solution(nums));
        System.out.println(demo.solution1(nums));
        System.out.println(demo.solution3(nums));

    }

    /**
     * 暴力两层遍历
     * @param nums
     * @return
     */
    public int solution(int []nums){

        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]&&i!=j){
                    break;
                }

                if(j==nums.length-1){
                    return nums[i];
                }
            }


        }
        return ans;


    }


    /**
     * 排序后 遍历
     * @param nums
     * @return
     */
    public int solution1(int []nums){
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0;i<nums.length;i+=2){
            if(i==nums.length-1){
                ans=nums[i];
                break;
            }

            if(nums[i]!=nums[i+1]){
                ans= nums[i];
                break;
            }
        }

        return ans;
    }


    /**
     * hashtable
     * @param nums
     * @return
     */
    public int solution2(int []nums){
        //略
        return 0;
    }

    /**
     * 异或解法
     * @param nums
     * @return
     */
    public int solution3(int []nums){
        //略
        int ans = 0;
        for(int i=0;i<nums.length;i++){

            ans ^=nums[i];
        }
        return ans;
    }
}
