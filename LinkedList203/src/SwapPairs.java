public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;

        ListNode res = swapPairs(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode cur = new ListNode(-1, head);
        ListNode pre = cur;

        while(pre.next != null && pre.next.next != null) {
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            pre = head;
            head = pre.next;
        }
        return cur.next;
    }
}
