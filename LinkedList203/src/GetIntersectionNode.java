public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        headA.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        ListNode headB = new ListNode(2);
        ListNode a1 = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(5);

        headB.next = a1;
        a1.next = b1;
        b1.next = c1;
        c1.next = null;

        ListNode ans = getIntersectionNode(headA,headB);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }


    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0;
        int lenB = 0;

        while(curA != null) {
           lenA++;
           curA = curA.next;
        }
        while(curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if(lenA >= lenB) {
            ListNode tmpNode = curB;
            curB = curA;
            curA = tmpNode;

            while(lenA != lenB ) {
                curA = curA.next;
                lenA--;
            }
            while (curA != null) {
                if(curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;

            while(lenB != lenA) {
                curB = curB.next;
                lenB--;
            }
            while(curB != null) {
                if(curB == curA) {
                    return curB;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}
