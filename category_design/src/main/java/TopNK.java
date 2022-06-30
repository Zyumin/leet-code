import java.util.PriorityQueue;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-08-14 5:31 PM
 */
public class TopNK {

    public static void main(String[] args) {

        int nums[] = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        //默认
        PriorityQueue<Integer> queue  = new PriorityQueue();

        for(int i :nums){
            queue.add(i);
            if(queue.size()>k){
                queue.poll();
            }
        }

        System.out.println(queue.peek());
    }
}
