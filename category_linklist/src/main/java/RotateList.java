/**
 * @author zhengyumin
 * @description :https://leetcode-cn.com/problems/rotate-list

给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL


 * @date 2020-07-08 8:52 PM
 */
public class RotateList {

    /**
     * 解题思路：把组成环，然后找到合适的位置断开
     * 当 k<n , k-n   new head
     * 当 k>n , k-n%k  new head
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1) ;
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3) ;
        l1.next.next.next = new ListNode(4) ;
        l1.next.next.next.next = new ListNode(5) ;

        ListNode listNode = solution(l1,2);

        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }

    }

    public static ListNode solution(ListNode node, int k){
        //bad case

        ListNode head = node;
        ListNode tail = node;

        //计算长度
        int n =1;
        for(;tail.next!=null;tail = tail.next){
            n++;
        }
        //组成环
        tail.next = head;

        // k-n%k-1 找到尾巴， 方便断开
        for(int i =0;i< n-k%n-1;i++){
            head = head.next;
        }

        //记住头
        ListNode newHead = head.next;
        //断开环
        head.next = null;

        return newHead;
    }
}
