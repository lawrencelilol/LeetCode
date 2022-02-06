//import java.util.List;
//
//public class ReverseNodesinKGroups {
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode pre = null;
//        ListNode cur = head;
//        ListNode nxt = head.next;
//
//        int n = k;
//
//        while(cur != null && n > 0) {
//            ListNode tmp = nxt;
//            nxt = nxt.next;
//            tmp.next = cur;
//            cur.next = pre;
//
//            n--;
//            pre = cur;
//            cur = tmp;
//
//        }
//        return
//    }
//}
