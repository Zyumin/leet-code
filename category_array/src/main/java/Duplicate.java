/**
 * @author zhengyumin
 * @description 寻找重复
 * @date 2020-09-12 11:32 AM
 */
public class Duplicate {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
//                System.out.print(slow);
                fast = nums[nums[fast]];
//                System.out.print(fast);
//                System.out.println();
            } while (slow != fast);
//            slow = 0;
//            while (slow != fast) {
//                slow = nums[slow];
//                fast = nums[fast];
//            }
            return slow;
        }

    //1->3->2->3->2
    public static void main(String[] args) {
        //            0 1 2 3 4
        int []nums = {1,3,4,2,2};
        System.out.println(new Duplicate().findDuplicate(nums));
    }

}
