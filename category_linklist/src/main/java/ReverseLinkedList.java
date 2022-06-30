/**
 * @author zhengyumin
 * @description https://leetcode-cn.com/problems/reverse-linked-list

反转一个单链表。
示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 * @date 2020-07-08 11:26 PM
 */
public class ReverseLinkedList {


    /**
     * 解题思路：
     * 方法一：迭代
     * 方法二：递归
     * @param args
     */
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
     *  1->2->3
     *
     *  1<-2
     * @return
     */
    public ListNode reverse(ListNode node){
        ListNode prev = null;

        ListNode curr = node;
        while(curr!=null){
            ListNode temp  = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * k(n)
     * @param head
     * @return
     */
    public ListNode reverse2(ListNode head){
        if (head == null || head.next == null) {return head;}

        // p = 3
        ListNode p = reverse2(head.next);
        // 1->2->3
        // 当前层: 2
        // 3->2 2->null
        // 1->2<-3

        // 当前层:1
        // 2->1 1->null
        // 1<-2<-3
        head.next.next = head;
        head.next=null;

        return p;
    }


//    /**
//     * 迭代
//     * @param head
//     * @return
//     */
//    public static ListNode solution1(ListNode head){
//
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr!=null){
//            //记录后驱节点,防止丢失
//            ListNode nextTemp = curr.next;
//            //反转
//            curr.next = prev;
//
//            //移动前驱节点
//            prev = curr;
//            //移动当前节点
//            curr = nextTemp;
//        }
//
//        return prev;
//    }





    /**
     * 递归
     *  n(k+1)的下一个是n(k)
     *  则 nk.next.next = nk;
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        //注意 head == null 的判断
        if (head == null || head.next == null) {return head;}
        //先递归到尾部
        ListNode p = solution(head.next);
//        System.out.println(p.val);
        head.next.next = head;
        head.next = null;
        return p;

    }

}
