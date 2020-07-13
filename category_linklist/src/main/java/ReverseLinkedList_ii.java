/**
 * @author zhengyumin
 * @description  : https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL



 * @date 2020-07-08 11:57 PM
 */
public class ReverseLinkedList_ii {

    /**
     * 思路： 先实现反转前 n个
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1) ;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3) ;
        l1.next.next.next = new ListNode(4) ;
        l1.next.next.next.next = new ListNode(5) ;

        ListNode listNode = solution(l1,2,4);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }
    }

    static ListNode solution(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            // 相当于反转前 n 个元素
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = solution(head.next, m - 1, n - 1);
        return head;
    }


    static ListNode successor;
    // 将链表的前 n 个节点反转（n <= 链表长度）
    public static ListNode reverseN(ListNode head, int n){
        if(n==1){
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }

        ListNode p = reverseN(head.next,n-1);
        head.next.next = head;

        head.next = successor;
        return p;
    }
}
