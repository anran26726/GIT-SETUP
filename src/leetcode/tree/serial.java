/**
 * 序列化和反序列化
 * 序列化：将二叉树变为线性结构（存到字符串或数组里）
 * 反序列化：将字符串或数组还原成二叉树
 * 用什么样的方式序列化就用什么样的方式反序列化
 */

/** 1. 先中后序遍历 
    * 递归
*/

public static Queue<String> serial(Node head) {
    Queue<String> ans = new LinkedList<>();
    traverse(head, ans);
    return ans;
}

public static void traverse(Node head, Queue<String> ans) {
    if (head == null) {
        ans.add(null);
    } else {
        ans.add(String.valueOf(head.value)); // 前序
        traverse(had.left, ans);
        // ans.add(String.valueOf(head.value)); 中序
        traverse(head.right, ans);
        // ans.add(String.valueOf(head.value)); 后序

    }
}

/** 2. 层级遍历 */
// 序列化
public static Queue<String> levelSerial(Node head) {
    Queue<String> ans = new LinkedList<>();

    if (head == null) {
        ans.add(null);
    } else {
        ans.add(String.valueOf(head.value));

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                ans.add(String.valueOf(head.left.value));
                queue.add(head.left);
            } else {
                ans.add(null);
            }

            if (head.right != null) {
                ans.add(String.valueOf(head.right.value));
                queue.add(head.right);
            } else {
                ans.add(null);
            }
        }
    }
    return ans;
}

//反序列化
public static Node buildByLevelQueue(Queue<String> levelList) {
    if (levelList == null || levelList.size() == 0) {
        return null;
    }

    Node head = generateNode(levelList.poll());
    Queue<Node> queue = new LinkedList<>();
    if (head != null) {
        queue.add(head);
    }

    Node node = null;
    while (!queue.isEmpty()) {
        node = queue.poll();
        node.left = generateNode(levelList.poll());
        node.right = generateNode(levelList.poll());
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
    return head;
}

public static Node generateNode(String val) {
    if (val == null) {
        return null;
    }
    return new Node(Integer.valueOf(val));
}