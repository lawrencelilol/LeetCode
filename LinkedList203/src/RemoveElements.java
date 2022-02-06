
public class RemoveElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int val = 6;
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

        ListNode res = removeElements(head,val);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;

        while( cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
