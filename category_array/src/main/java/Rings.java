import java.util.LinkedList;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-10 3:02 PM
 */
public class Rings {
    public static void main(String[] args) {
        ring(10, 5);
    }

    public static void ring(int n, int m) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int k = 2;
        int element = 0;
        int i = 0;
        for (; i<k; i++) {
            element = q.poll();
            q.add(element);
        }
        i = 1;
        while (q.size() > 0) {
            element = q.poll();
            if (i < m) {
                q.add(element);
                i++;
            } else {
                i = 1;
                System.out.println(element);
            }
        }
    }

}
