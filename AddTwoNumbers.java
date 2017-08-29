/**
 * Link: https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        boolean carry = false;
        ListNode result = new ListNode(0);
        ListNode resIter = result;
        while(left != null && right != null) {

            // Prepare next node
            resIter.next = new ListNode(0);

            // Add both nodes values
            int sum = left.val + right.val + (carry ? 1 : 0);
            resIter.next.val = sum%10;
            carry = sum >= 10;

            // Move to next node
            left = left.next;
            right = right.next;
            resIter = resIter.next;
        }

        while(left != null) {
            resIter.next = new ListNode(0);
            int sum = left.val + (carry ? 1 : 0);
            resIter.next.val = sum%10;
            carry = sum >= 10;
            left = left.next;
            resIter = resIter.next;
        }

        while(right != null) {
            resIter.next = new ListNode(0);
            int sum = right.val + (carry ? 1 : 0);
            resIter.next.val = sum%10;
            carry = sum >= 10;
            right = right.next;
            resIter = resIter.next;
        }

        if(carry) {
            resIter.next = new ListNode(1);
        }

        return result.next;
    }
}
