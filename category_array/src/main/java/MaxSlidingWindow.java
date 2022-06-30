import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhengyumin
 * @description
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


解法：单调队列
 *
 * @date 2020-10-14 6:12 PM
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int num[] = {1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow demo = new MaxSlidingWindow();
        int []res = demo.maxSlidingWindow(num,3);

        for(int a:res){
            System.out.print(a+" ");
        }


    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        MonitorQueue windows = new MonitorQueue();
        int []result = new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
            windows.push(nums[i]);
//            System.out.println(windows.data.toString());
            if(i+1>=k){
                result[index++] = windows.max();
                windows.pop(nums[i]);
            }
        }

        return result;
    }


    class MonitorQueue{

        public MonitorQueue() {
            this.data = new LinkedList<Integer>();
        }

        private Deque<Integer> data;

        /**
         * 类似单调栈
         * @param num
         */
        public void push(int num){
            while(!data.isEmpty()&& data.getLast()<num){
                data.pollLast();
            }
            data.addLast(num);
        }

        /**
         * 需要从头移除
         * @param num
         */
        public void pop(int num){
            if(!data.isEmpty()&& data.getFirst()==num){
                data.getFirst();
            }
        }

        public int max(){
            return data.getFirst();
        }
    }
}
