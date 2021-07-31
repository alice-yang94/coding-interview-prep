/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {
        /* space O(n) time O(n) */
        
        // 1. get mid node
        ListNode fast = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        
        // 2. put second half in a stack
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = mid.next;
        while (curr != null) {
            stack.add(curr);
            curr = curr.next;
        }
        
        // remove second half
        mid.next = null;
        
        // 3. start from head, pop elem from stack insert to even idx positions
        curr = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            ListNode next = curr.next;
            curr.next = node;
            node.next = next;
            
            curr = curr.next.next;
        }
        
    }
}