/**
 * @author zhengyumin
 * @description
 *
 *
 *  二分法
 * @date 2020-10-16 10:56 PM
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] num,int H) {

        int max = 0;

        for (int i : num) {
            max = Math.max(i, max);
        }
        int left = 0, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //can finish
            if (canFinish()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
    private boolean canFinish() {
        return false;
    }


    public static void main(String[] args) {

    }
}
