/**
 * 找宽度最大的层
 */

/** 1. 用到HashMap */
public static void maxWidthUseMap(Node head) {
    if (head == null) {
        return 0;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(head);

    HashMap<Node, Integer> levelMap = new HashMap<>();
    levelMap.put(head, 1);

    int current_level = 1; // 记录当前正在统计哪一层
    int current_level_nodes = 0; // 记录当前层的宽度是多少 (当前层的节点数)
    int max = 0;
    while (!queue.isEmpty()) {
        Node current = queue.poll(); 
        int current_node_level = levelMap.get(current); 
        if (current.left != null) {
            levelMap.put(current.left, current_node_level + 1);
            queue.add(current.left);
        }
        if (current.right != null) {
            levelMap.put(current.right, current_node_level + 1);
            queue.add(current.right);
        }

        if (current_node_level == current_level) {
            current_level_nodes++;
        } else {
            max = Math.max(max, current_level_nodes);
            current_level++;
            current_level_nodes = 1;
        }
    }
    max = Math.max(max, current_level_nodes);
    return max;
}

/** 2. 不用到HashMap */
public static void maxWidthNoMap(Node head) {
    if (head == null) {
        return 0;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(head);

    Node curEnd = head; // 当前层最右一个节点
    Node nextEnd = null; // 如果有下一层， 下一层的最右节点
    int max = 0;
    int curLevelNodes = 0; // 当前层的节点数
    while (!queue.isEmpty()) {
        Node cur = queue.poll();
        if (cur.left != null) {
            queue.add(cur.left);
            nextEnd = cur.left;
        }
        if (cur.right != null) {
            queue.add(cur.right);
            nextEnd = cur.right;
        }
        curLevelNodes++;
        if (cur == curEnd) {
            max = Math.max(max, curLevelNodes);
            curLevelNodes = 0;
            curEnd = nextEnd;
        }
    }
    return max;
}