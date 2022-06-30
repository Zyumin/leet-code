import java.util.Arrays;

/**
 * @author zhengyumin
 * @description
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 * 区间合并问题
 * @date 2020-08-21 3:43 PM
 */
public class MergeIntervals {

    public static void main(String[] args) {


        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge1(intervals);

        for (int[] t : result) {
            System.out.println(t[0] + "," + t[1]);
        }

    }

    public static int[][] merge1(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {

            //不重叠 直接入队  当前左边界([) > 上一个区间右边界(])
            if (index==0||interval[0] > result[index-1][1]) {
                result[index++] = interval;

            } else {
                //取当前边界和上一个边界的最大值
                result[index-1][1] = Math.max(result[index-1][1], interval[1]);
            }
        }

        return Arrays.copyOf(result,index);
    }


    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];
        int index = 0;
        int[] pre = {};
        for (int[] interval : intervals) {
            if (pre.length == 0) {
                pre = interval;
                continue;
            }
            //重叠,继续保持pre
            if (interval[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], interval[1]);
            } else {
                //不重叠 pre入队,更替pre
                result[index++] = pre;
                pre = interval;
            }
        }


        //处理最后一个pre
        result[index++] = pre;

        return Arrays.copyOf(result,index);
    }
}
