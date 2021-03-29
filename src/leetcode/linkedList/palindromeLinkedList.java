/**
 * 给定一个单链表的头节点head，判断该链表是否为回文结构
 * 1. 栈
 *    遍历链表，把每个节点（或者中点右侧的节点）加到栈里，再取出比较；因为栈是先进后出的结构，所以可以比较回文
 * 2. 直接修改原链表（*需要注意边界）
 *    快慢指针找到中点，右半部分逆序
 *    首尾两个指针向中间遍历比较
 *    *再将右半部分遍历回来
 */

/** 1 */
public static boolean isPalindrome1(Node head) {
    Stack<Node> stack = new Stack<Node>();
    Node cur = head;
    while (cur != null) {
        stack.push(cur);
        cur = cur.next;
    }
    while (head != null) {
        if (head.value != stack.pop().value) {
            return false;
        }
        head = head.next;
    }
    return true;
}

public static boolean isPalindrome2(Node head) {
    if (head == null || head.next == null) {
        return true;
    }

    Stack<Node> stack = new Stack<Node>();
    Node cur = head;
    Node right = head.next;
    while (cur.next != null || cur.next.next != null) {
        right = right.next;
        cur = cur.next.next;
    }
    while (right != null) {
        stack.push(right);
        right = right.next;
    }
    while (!stack.isEmpty()) {
        if (head.value != stack.pop().value) {
            return false;
        }
        head = head.next;
    }
    return true;
}

/** 2 */
public static boolean isPalindrome3(Node head) {
    if (head == null || head.next == null) {
        return true;
    }

    // 快慢指针
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next != null) { // find mid node
        slow = slow.next; // slow -> mid
        fast = fast.next.next; // fast -> end
    }
    fast = slow.next; // ? fast指针重新指向右侧的第一个节点
    slow.next = null; // mid.next -> null

    // 逆序
    Node right_next = null;
    while (fast != null) {
        right_next = fast.next; // right_next -> save next node
        fast.next = slow; 
        slow = fast;
        fast = right_next;
    }
    right_next = slow;
    fast = head;

    boolean res = true;
    while (slow != null && fast != null) {
        if (slow.value != fast.value) {
            res = false;
            break;
        }
        slow = slow.next;
        fast = fast.next;
    }

    // 再次逆序
    slow = right_next.next;
    right_next = null;
    while (slow != null) {
        fast = slow.next;
        slow.next = right_next;
        right_next = slow;
        slow = fast;
    }
    return res;
}


