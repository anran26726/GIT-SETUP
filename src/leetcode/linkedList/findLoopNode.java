/**
 * 1. HashSet记录内存地址
 * 2. 快慢指针
 *    先是慢指针走一步，快指针走两步，如果有环，快慢指针一定会相遇
 *    当快慢指针相遇以后，快指针回到头节点，慢指针停在原地
 *    快指针改为走一步，慢指针也走一步，当快慢指针再次相遇的时候，就是环的入口节点，返回
 */

public static Node findLoopNode(Node head) {
    if (head == null || head.next == null || head.next.next == null) {
        return null;
    }

    Node slow = head.next;
    Node fast = head.next.next; //快慢指针初始化的时候不能指向head，因为while的条件是 slow != fast
    while (slow != fast) {
        if (fast.next == null || fast.next.next == null) { //如果快指针走到null了，证明无环，return null
            return null;
        }
        slow = slow.next;
        fast = fast.next.next;
    }

    fast = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}