/** 
 * 对称树（镜像树）
 */

/** 1. 递归 O(N) O(N) */
public boolean isSymmetric(TreeNode root) {
    return isEqual(root, root);
}

public boolean isEqual(TreeNode leftRoot, TreeNode rightRoot) {
    if (leftRoot == null && rightRoot == null) {
        return true;
    }
    
    if (leftRoot == null || rightRoot == null) {
        return false;
    }
    
    return leftRoot.val == rightRoot.val && isEqual(leftRoot.left, rightRoot.right) && isEqual(leftRoot.right, rightRoot.left);
}

/** 2. 序列化？ */
public boolean isSymmetric(TreeNode root) {
    return isEqual(root, root);
}

public boolean isEqual(TreeNode leftRoot, TreeNode rightRoot) {
    Queue<TreeNode> queue =  new LinkedList<>();
    queue.add(leftRoot);
    queue.add(rightRoot);
    
    while (!queue.isEmpty()) {
        leftRoot = queue.poll();
        rightRoot = queue.poll();
        
        if (leftRoot == null && rightRoot == null) {
            continue;
        }
        
        if ((leftRoot == null || rightRoot == null) || (leftRoot.val != rightRoot.val)) {
            return false;
        }

        queue.add(leftRoot.left);
        queue.add(rightRoot.right);
        
        queue.add(leftRoot.right);
        queue.add(rightRoot.left);
    }
    return true;
}