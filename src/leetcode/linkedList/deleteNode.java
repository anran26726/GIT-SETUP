/**
 * 删除指定的节点
 * 因为无法访问之前的节点，因此 我们需要把后一个节点的值赋给当前节点再删掉后一个节点
 */

public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}