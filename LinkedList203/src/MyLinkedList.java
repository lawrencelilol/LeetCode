

public class MyLinkedList {
    int size;
    ListNode head;

    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.get(2);
    }

    public MyLinkedList() {
       size = 0;
       head = new ListNode(0);
    }

    public int get(int index) {
        if(index >= size || index < 0) {
            return -1;
        }
        ListNode cur = head;

        for (int i = 0; i <= index ; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }

        if(index < 0) {
            index = 0;
        }

        size++;// Increase the size of the LinkedList

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // Adding the new element to the list
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index < size && index >= 0) {
            ListNode cur = head;
            size--;

            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }
}
