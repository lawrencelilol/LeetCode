public class ReverseLinkedList {

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

        ListNode res = reverseList(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
