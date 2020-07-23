import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengyumin
 * @description
 * 以时间复杂度O(n)从长度为n的数组中找出同时满足下面两个条件的所有元素：
（1）该元素比放在它左边的所有元素都大；
（2）该元素比放在它右边的所有元素都小。

输入：一个数组

输出：返回一个数组，数组中保存的是符合条件的元素的下标。

 * @date 2020-07-16 3:33 PM
 */
public class MaxLeftMinRight {

    public static void main(String[] args) {

        int dTestArray[]={1,8,6,9,10,15,12,20};
        solution(dTestArray).forEach(a-> System.out.println(a));

    }

    public static List solution(int[] nums){

        List<Integer> list = new ArrayList();

        int []leftMax = new int[nums.length];
        int []rightMin =  new int[nums.length];

        leftMax[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],nums[i]);

        }

        rightMin[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            rightMin[i] = Math.min(rightMin[i+1],nums[i]);

        }


        for(int i=1;i<nums.length-1;i++){
//            System.out.println(nums[i]+","+leftMax[i]+","+rightMin[i]);
            if(leftMax[i]<=nums[i] && nums[i]<=rightMin[i]){
                list.add(nums[i]);
            }
        }


        return list;
    }
}
