import java.util.Arrays;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-08-19 6:02 PM
 */
public class TwoSumSp {

    public static void main(String[] args) {

        int[] arr = new int[]{-8, -4, -3, 0, 1, 2, 4, 5, 8, 9, 9};
        int k = 10;

//        System.out.println(twoSum(arr, k));

        for (int[] t : threeSumTemplate(arr, k)) {
            System.out.println(t[0] + "," + t[1]+ "," + t[2]);
        }
    }

    public static int[][] twoSum(int[] arr, int k) {
        // write code here
        int left = 0, right = arr.length - 1;
        int[][] result = new int[arr.length][2];
        int index = 0;
        while (left < right) {

            if (arr[left] + arr[right] == k) {
                if (left == 0 || arr[left] != arr[left - 1]) {
                    result[index++] = new int[]{arr[left], arr[right]};
                }
                left++;
                right--;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            }
        }
        return Arrays.copyOf(result, index);
    }


    public static int[][] twoSumTemplate(int[] arr, int start,int k) {
        // write code here
        int left = start, right = arr.length - 1;

        int[][] result = new int[arr.length][2];

        int index = 0;
        while (left < right) {

            int leftTemp = arr[left];
            int rightTemp = arr[right];
            if (arr[left] + arr[right] == k) {
                result[index++] = new int[]{arr[left], arr[right]};
                while (left < right && arr[left] == leftTemp) {
                    left++;
                }
                while (left < right && arr[right] == rightTemp) {
                    right--;
                }
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            }
        }
        return Arrays.copyOf(result, index);
    }

    public static int[][] threeSumTemplate(int[] arr,int k) {
        // write code here

        int[][] result = new int[arr.length][3];

        int index = 0;
        for(int i=0;i<arr.length;i++){

            int [][]t = twoSumTemplate(arr,i,k-arr[i]);

            for(int []a:t){
                result[index++] = new int[]{arr[i],a[0],a[1]};
            }

            //跳过
            while(i<arr.length-1&&arr[i]==arr[i+1]) {i++;}
        }
        return Arrays.copyOf(result, index);
    }


}
