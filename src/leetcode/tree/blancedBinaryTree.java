/** 平衡二叉树 
 * // 平衡树
        // 每一颗子树的左树和右树的高度差不超过1
    // 递归
    //左树平衡
    //右树平衡
    //左树高度和右树高度差不超过1(<2)
*/

public static boolean isBalanced2(Node head) {
    return process2(head).isBalanced;
}

public static class Info { // Info 是信息返回的结构体
    public boolean isBalanced;
    public int height;

    public Info(boolean b, int h) {
        isBalanced = b;
        height = h;
    }
}

public static Info process2(Node head) {
    if (head == null) {
        return new Info(true, 0);
    }

    Info leftInfo = process2(head.left);
    Info rightInfo = process2(head.right);

    int height = Math.max(leftInfo.height, rightInfo.height) + 1; //左子树高度 ? 右子树高度 + 头节点高度（1）
    boolean isBalanced = true;

    if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height - rightInfo.height) > 1) {
        isBalanced = false;
    }

    return new Info(isBalanced, height);
}

