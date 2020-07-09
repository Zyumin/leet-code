/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 给定一个链表，判断链表中是否有环。
 * @date 2020-07-09 11:18 AM
 */
public class LinkedListCycle {

    /**
     * 解题思路:快慢指针的方式，如果重合则说明成环，结束条件（慢指针走到尾部）
     *
     * 无法高效获取长度，无法根据偏移快速访问元素，是链表的两个劣势。然而面试的时候经常碰见诸如
     *
     * 获取倒数第k个元素，
     * 获取中间位置的元素，
     * 判断链表是否存在环，
     * 判断环的长度等和长度与位置有关的问题
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1) ;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3) ;
        l1.next.next.next = new ListNode(4) ;
        l1.next.next.next.next = new ListNode(5) ;
        l1.next.next.next.next.next = l1;

        System.out.println(solution(l1));
    }

    private static boolean solution(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while(slow!=fast){
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;


    }
}
