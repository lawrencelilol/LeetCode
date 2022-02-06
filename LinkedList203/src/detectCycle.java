/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class detectCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        ListNode ans = detectCycle(head);

    }
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                ListNode idx1 = head;
                ListNode idx2 = fast;

                while(idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx1;
            }
        }
        return null;
    }
}
