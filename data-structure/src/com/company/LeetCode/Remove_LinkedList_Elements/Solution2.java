package com.company.LeetCode.Remove_LinkedList_Elements;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * 采用虚拟节点的方式进行删除
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

       //创建虚拟节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(a);
        System.out.println(head);

        head = (new Solution2()).removeElements(head,6);
        System.out.println(head);
    }
}
