/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-19 3:09 PM
 */
public class QuickSort {


    private void swap(int []nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void quickSort(int[]nums,int left,int right){

        int sourceLeft = left;
        int sourceRight = right;
        /**
         * [1..n]
         * select a pivot value
         *
         *
         *
         * sort [1...pivot-1]
         * sort [pivot+1...n]
         */
        if(left>right){
            return;
        }

        int pivot = left;
        while(left<right){
            while(left<right&& nums[pivot] <=nums[right]){
                right--;
            }
            while(left<right&& nums[pivot] >=nums[left]){
                left++;
            }
            if(left<right){
                //swap
                swap(nums,left,right);
            }
        }
        //swap
        swap(nums,left,pivot);

        for(int n:nums){
            System.out.print(n);
        }
        System.out.println(", nums[pivot]:"+nums[left]);

        quickSort(nums,sourceLeft,left-1);
        quickSort(nums,left+1,sourceRight);

    }

    public static void main(String[] args) {

        int []nums = {7,5,4,1,2,3,9,8,6};

        QuickSort demo = new QuickSort();
        demo.quickSort(nums,0,nums.length-1);

        System.out.println("ans:");
        for(int n:nums){
            System.out.print(n);
        }

    }

}
