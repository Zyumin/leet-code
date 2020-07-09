import java.util.LinkedList;

/**
 * @author zhengyumin
 * @description  https://leetcode-cn.com/problems/add-two-numbers
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

 * @date 2020-07-08 7:54 PM
 */
public class AddTwoNumbers {

    /**
     * 解决思路: 遍历两个链表， 十进制进1 ，
     * @param args
     */
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2) ;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3) ;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = solution(l1,l2);
        while(listNode!=null){
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }
    }

    public static ListNode solution(ListNode l1,ListNode l2){
        //bad case

        ListNode head = new ListNode(0);
        ListNode curr = head;

        int carry =0;
        while(l1!=null||l2!=null){
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            int result = a+b+ carry;
            carry = result/10;
            curr.next = new ListNode(result%10);
            curr = curr.next;
            if(l1!=null){ l1=l1.next;}
            if(l2!=null){ l2=l2.next;}
        }

        if(carry>0){
            curr.next = new ListNode(carry);
        }

        return head.next;
    }



}
