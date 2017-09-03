/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = head;
        if(head != null && head.next != null) {
            newHead = head.next;
        }
        
        ListNode tmp = head;
        while(tmp != null && tmp.next != null) {
            ListNode next = tmp.next.next;
            ListNode nextP2 = next;
            if(next != null && next.next != null) {
                nextP2 = next.next;
            }
            ListNode p2 = tmp.next;
            tmp.next = nextP2;
            p2.next = tmp;
            tmp = next;
        }
        
        return newHead;
    }
}
