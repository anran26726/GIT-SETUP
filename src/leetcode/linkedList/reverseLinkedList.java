/**
 * 链表翻转
 */

public static reverseLinkedList(Node head) {
    DoubleNode pre = null;
    DoubleNode next = null;

    while (head != null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }

    return pre;
}