/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-14 4:20 PM
 */
public class BinarySearch {

//        Integer[] a = {2,1,2,4,3};
//        List<Integer> integers = Arrays.asList(a);
//        ArrayList<Object> list = new ArrayList<>();
//        for (int i = 0; i < integers.size(); i++) {
//            //这特么能到达？？
//            if (i == integers.size()){
//                return;
//            }
//            //这特么命名？
//            Integer integer = integers.get(i);
//            //这特么嫌空间多？
//            List<Integer> integers1 = integers.subList(i + 1, integers.size());
//            Iterator<Integer> iterator = integers1.iterator();
//            Integer max = null;
//            while (iterator.hasNext()){
//                Integer next = iterator.next();
//                if (next> integer){
//                    max = next;
//                    break;
//                }
//            }
//            //这特么max 不可以先给初始值？
//            if (max == null){
//                max = -1;
//            }
//            list.add(max);
//        }
//        System.out.println("list = " + list);


    /**
     *  二分法查找
     * @param num 数组
     * @param target 目标值
     * @return
     */
    public int binarySearch(int num[],int target){
        /**
         * [left,right]
         */
        int left = 0,right=num.length-1;
        while(left<=right){

            int mid = left+ (right-left)/2;

            if(num[mid]>target){
                right = mid-1;
            } else if(num[mid]<target){
                left = mid+1;
            } else if(num[mid]==target){
                return mid;
            }
        }
        return -1;
    }


    /**
     * 返回左边界
     * @param num
     * @param target
     * @return
     */
    public int binarySearchLeft(int num[],int target){
        /**
         * [left,right]
         */
        int left = 0,right=num.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(num[mid]>target){
                right = mid-1;
            } else if(num[mid]<target){
                left = mid+1;
            } else if(num[mid]==target){
                //锁定左边边界
                right = mid - 1;
            }
        }
        if(left>=num.length||num[left]!=target){
            return -1;
        }
        return left;
    }

    /**
     * 返回右边界
     * @param num
     * @param target
     * @return
     */
    public int binarySearchRight(int num[],int target){
        /**
         * [left,right]
         */
        int left = 0,right=num.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(num[mid]>target){
                right = mid-1;
            } else if(num[mid]<target){
                left = mid+1;
            } else if(num[mid]==target){
                left = mid + 1;
            }
        }
        if(right<0||num[right]!=target){
            return -1;
        }
        return right;
    }


    public static void main(String[] args) {
        BinarySearch demo = new BinarySearch();
        int []num = {1,2,3,6,6,6,7,8,10};
        System.out.println(demo.binarySearch(num,6));
        System.out.println(demo.binarySearchLeft(num,6));
        System.out.println(demo.binarySearchRight(num,6));
    }


    private void swap(int []nums,int a,int b){
        nums[a] = nums[a]^nums[b];
        nums[b] = nums[a]^nums[b];
        nums[a] = nums[a]^nums[b];
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
            while(left<right&& nums[pivot] <nums[right]){
                right--;
            }
            while(left<right&& nums[pivot] >nums[left]){
                left++;
            }
            if(left<right){
                //swap
                swap(nums,left,right);
            }
        }
        //swap
        swap(nums,left,pivot);

        quickSort(nums,sourceLeft,pivot-1);
        quickSort(nums,pivot+1,sourceRight);

    }
}
