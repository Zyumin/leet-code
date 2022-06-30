/**
 * 移动0到后面
 *
 * 双指针
 */
class MoveZeroes {

    public void moveZeroes(int[] nums) {
        //0
        int left = 0;
        //移动到第一个非0
        int right = 0;

        int length = nums.length;
        for (right = 0; right < length; right++) {

            if(nums[right]!=0){
                //swap left right
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;

                left++;
            }

        }

    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        //int[] nums = {0, 1, 0, 3, 12};
        // 1 3 0 0 12

        new MoveZeroes().moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}