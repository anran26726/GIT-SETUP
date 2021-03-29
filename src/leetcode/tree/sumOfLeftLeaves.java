/**
 * 左边叶子节点的和
 */

/** 1. 递归 */

/** 2. 宽搜 */
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int sum = 0;
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
            if (cur.left.left == null && cur.left.right == null) {
                sum += cur.left.val;
            } else {
                queue.add(cur.left);
            }
        }
        if (cur.right != null) {
            if (!(cur.right.left == null && cur.right.right == null)) {
                queue.add(cur.right);
            }
        }
    }
    return sum;
}

/** 3. 深搜 */