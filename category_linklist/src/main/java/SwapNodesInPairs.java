/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.


 * @date 2020-07-09 12:09 AM
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1) ;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3) ;
        l1.next.next.next = new ListNode(4) ;
        l1.next.next.next.next = new ListNode(5) ;

        ListNode listNode = solution(l1);

        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }

    }

    /**
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head){


        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //记录前驱节点
        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }


    public static ListNode solution(ListNode head){
        //注意 head == null 的判断
        if (head == null || head.next == null) {return head;}
        //先递归到尾部

        ListNode first = head;
        ListNode second = head.next;

        first.next = solution(second.next);

        second.next = first;
        return second;

    }
}
