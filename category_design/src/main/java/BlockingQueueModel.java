import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-06-15 11:32 PM
 */
public class BlockingQueueModel {

    public BlockingQueue<Integer> queue;

    private final AtomicInteger increTaskNo = new AtomicInteger(0);


    public BlockingQueueModel(int cap) {
        // LinkedBlockingQueue 的队列是 lazy-init 的，但 ArrayBlockingQueue 在创建时就已经 init
        this.queue = new LinkedBlockingQueue<>(cap);
    }

    public class Producer implements Runnable{
        @Override
        public void run() {
            while(true) {
                try {
                    queue.put(increTaskNo.addAndGet(1));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public class Consumer implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(queue.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        BlockingQueueModel model = new BlockingQueueModel(3);

        for(int i =0;i<10;i++){
            new Thread(model.new Producer()).start();

        }

        for(int i =0;i<2;i++){
            new Thread(model.new Consumer()).start();

        }
    }
}
