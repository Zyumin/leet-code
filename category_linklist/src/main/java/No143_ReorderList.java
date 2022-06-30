/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-20 9:34 PM
 */
public class No143_ReorderList {


    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * <p>
     * 例子:给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        No143_ReorderList demo = new No143_ReorderList();
        demo.solution(l1);

        while(l1!=null){
            System.out.println(l1.val);
            l1 = l1.next;
        }

    }

    public void solution(ListNode head) {

        ListNode midPoint = middleNode(head);

        ListNode l1 = head;
        ListNode l2 = midPoint.next;
        //断开链接
        midPoint.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;

        }
    }

    /**
     * 迭代法反转链表
     *
     * @param l2
     * @return
     */
    private ListNode reverseList(ListNode l2) {

        ListNode curr = l2;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 快慢指针找到中点
     *
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
