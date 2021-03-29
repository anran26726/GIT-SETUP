/**
 * 层级遍历
 * 队列实现
 * flag判定层是否结束
 */

public static void levelTraverse(Node head) {
    if (head == null) {
        return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    while (!queue.isEmpty()) {
        Node cur = queue.poll();
        System.out.print(); // 根据题目的不同，逻辑应该在这里改动
        if (cur.left != null) {
            queue.add(cur.left);
        }
        if (cur.right != null) {
            queue.add(cur.right);
        }
    }

}