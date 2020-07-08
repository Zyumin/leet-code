import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

    示例:

    输入:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    输出: 1->1->2->3->4->4->5->6

 * @date 2020-07-08 8:35 PM
 */
public class MergeKSortedLists {


    /**
     * 解题思路
     * 方法一: 暴力 两两合并链表
     * 方法二: 使用优先级队列 （本次实现）
     * 方法三: 两两合并 分治法
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1,l2,l3};

        ListNode listNode = solution(lists);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }



    }

    public static ListNode solution(ListNode[] lists) {

        //bad case
        if (lists == null || lists.length == 0) {return null;}


        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {return -1;}
                else if (o1.val == o2.val){ return 0;}
                else {return 1;}
            }
        });

        ListNode head  = new ListNode(0);
        ListNode curr = head;
        for(ListNode node: lists){
            queue.add(node);
        }

        while(!queue.isEmpty()){
            curr.next = queue.poll();
            curr = curr.next;
            if(curr.next!=null) {queue.add(curr.next);}
        }



        return head.next;
    }


}
