/**
 * 单链表中的环
 * 经典的快慢指针问题（追击）
 * 慢指针走一步，快指针走两步，如果链表中有环，快慢指针终将相遇
 */

public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}