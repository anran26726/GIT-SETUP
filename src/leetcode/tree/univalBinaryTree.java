/**
 * 单值二叉树
 * 二叉树中所有的节点值是否相等
 */

/** 1. 递归 */
public boolean isUnivalTree(TreeNode root) {
    boolean left_correct = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
    boolean right_correct = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
    return left_correct && right_correct;
}
/** 2. BFS 宽搜 层级遍历 */
public boolean isUnivalTree(TreeNode root) {
    if (root == null) {
        return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
            if (cur.val != cur.left.val) {
                return false;
            }
            queue.add(cur.left);
        }
        
        if (cur.right != null) {
            if (cur.val != cur.right.val) {
                return false;
            }
            queue.add(cur.right);
        }
    }
    return true;
}
/** 3. DFS 深搜 */