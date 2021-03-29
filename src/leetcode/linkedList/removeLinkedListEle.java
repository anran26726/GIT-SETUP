/**
 * 移除链表元素 Remove all elements from a linked list of integers that have value val
 * 最大的问题是：如果头节点的值等于val，头节点被移除，链表就没有头节点了
 * 解决方法：使用哨兵节点 dummy，使得链表永不为空，永不空头
 */
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode node = head;
    
    while (node != null) {
        // if (node.val != val) {
        //     pre = node;
        //     node = node.next;
        // } else {
        //     node = node.next;
        //     pre.next = node;
        // }
        if (node.val == val) pre.next = node.next;
        else pre = node;
        node = node.next;
    }

    return dummy.next;
}