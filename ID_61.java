/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        ListNode tmp = head;
        ListNode newHead = head;
        ListNode oldLast = head;
        
        // Get the size of the list
        int size = 0;
        while(tmp != null) {
            size++;
            oldLast = tmp;
            tmp = tmp.next;
        }
        
        // Update k
        k %= size;
        
        // If one element only
        if(k == 0) {
            return head;
        }
                
        // Search for new last
        tmp = head;
        k = size - k;
        while(k > 1) {
            tmp = tmp.next;
            k--;
        }
        
        // Set the new head
        newHead = tmp.next;
        
        // Set the new last
        tmp.next = null;
        
        // Update link
        oldLast.next = head;
        
        return newHead;
    }
}
