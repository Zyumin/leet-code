import java.util.ArrayList;
import java.util.List;

/**
 * 找到丢失的数字
 */
class DisappearedNum {

    /**
     * 解法:给对应下标打上负数
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            nums[index] =  -1 * Math.abs(nums[index]);
        }
//        for(int num:nums){
//            System.out.println(num);
//        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        new DisappearedNum().findDisappearedNumbers(num).stream().forEach(bo -> System.out.print(bo));
    }
}