import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengyumin
 * @description 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @date 2020-09-04 4:49 PM
 */
public class PalindromeLinkedList {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);

        //v1
//        first = l1;
//        System.out.println(new PalindromeLinkedList().solutionV1(l1));

        //v2
//        System.out.println(new PalindromeLinkedList().solutionV2(l1));
        //v3
        System.out.println(new PalindromeLinkedList().solutionV3(l1));

    }

    static ListNode first;

    /**
     * 利用递归到达尾部，利用栈特性 ，再与外部正向遍历比较
     *
     * @param head
     * @return
     */
    public boolean solutionV1(ListNode head) {
        if (head == null) {
            return true;
        }
        if (solutionV1(head.next) == false) {
            return false;
        }
        if (head.val != first.val) {
            return false;
        }
        first = first.next;
        return true;
    }



    public boolean isPalindrome(ListNode head){
        if(head==null){
            return true;
        }

        if(isPalindrome(head.next)==false||head.val != first.val){
            return false;
        }
        first = first.next;

        return true;
    }




    /**
     * 1.快慢指针，找到中点(也可以边前进边反转)2.反转后半部 3.再比较
     *
     * @param head
     * @return
     */
    public boolean solutionV2(ListNode head) {

        // 1->(2)->2->1
        ListNode tail = findMid(head);

        // 1->2->2(<-)1
        ListNode newHead = reverse(tail.next);

        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }


    /**
     * 找到中点
     * 1—>2->3   slow->2
     * 1->2->3->4  slow->2
     *
     * @param head
     * @return
     */
    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表
     * 1->2->3
     * head =2  head.next = 3   head.next.next = head  (3->2)
     * head.next = null; (2|->|3)
     *
     * @return
     */
    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //新头节点
        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        //返回新头节点
        return tail;

    }


    /**
     * 拷贝到数组 两端遍历
     * @param head
     * @return
     */
    public boolean solutionV3(ListNode head) {

        List<Integer> list = new ArrayList<Integer>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }


        for(int i =0;i<=list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }

        return true;
    }

}
