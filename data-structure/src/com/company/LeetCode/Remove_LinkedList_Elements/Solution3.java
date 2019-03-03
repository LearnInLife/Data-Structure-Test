package com.company.LeetCode.Remove_LinkedList_Elements;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * <p>
 * 采用递归的方式解决
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

//        ListNode res = removeElements(head.next, val);
//
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(a);
        System.out.println(head);

        head = (new Solution3()).removeElements(head, 6);
        System.out.println(head);
    }
}
