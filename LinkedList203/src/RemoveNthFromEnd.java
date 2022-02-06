public class RemoveNthFromEnd {
    
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
        d.next = null;

        
        ListNode ans = removeNthFromEnd(head,2);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // Brute Force
//        int count = 0;
//        ListNode dummy = new ListNode(-1, head);
//        ListNode cur = head;
//
//        while(cur != null) {
//            cur = cur.next;
//            count++;
//        }
//
//        cur = head;
//        int index = 1;
//
//        if(count - n == 0) {
//            return head.next;
//        }
//
//        while(cur != null) {
//            if(index == count - n) {
//                ListNode tmp = cur.next.next;
//                cur.next = tmp;
//                cur = cur.next;
//                index++;
//            } else {
//                index++;
//                cur = cur.next;
//            }
//        }
//        return dummy.next;

        // fast and slow
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;

        while(count < n+1) {
            fast = fast.next;
            count++;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next.next;
        slow.next = tmp;

        return dummy.next;
     }
}
