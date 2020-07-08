/**
 * @author zhengyumin
 * @description : https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *  
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2020-07-08 8:18 PM
 */
public class MergeTwoSortedLists {

    /**
     * 解题思路 ：遍历两个链表 比较大小,其中一个为空的时候并入另一个尾部
     * 关键词： 链表遍历
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode listNode = solution(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }

    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        //bad case
        ListNode head = new ListNode(0);
        ListNode curr = head;


        while (l1 != null && l2 != null) {
            curr.next = new ListNode(Math.min(l1.val,l2.val));
            curr = curr.next;
            if(l1.val>l2.val){
                l2 = l2.next;
            }else{
                l1 = l1.next;
            }
        }
        curr.next = l1==null?l2:l1;
        return head.next;
    }
}
