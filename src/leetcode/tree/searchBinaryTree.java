/** 
 * 搜索二叉树
 * 整个树上没有重复值
 * 且左树的值都比头小，右树的值都比头大
 * 
 * 给定一棵二叉树的头节点head
 * 返回这棵二叉树中最大的二叉搜索子树的头节点
 * 1. 与x无关
 *    要么是左树的头节点
 *    要么是右树的头节点
 * 2. 与x有关
 *    x的左树是搜索二叉树 左max < x
 *    x的右树是搜索二叉树 右min > x
 * left: size, isBST, max
 * right: size, isBST, min
 * 由于左树要求和右树的要求不完全相同，所以需要求全集，即左树也要记录min值，右树也要记录max值
 */


public static int maxSubBSTSize(Node head) {
    if (head == null) {
        return 0;
    }

    return process(head).maxSubBSTSize;
}

public static class Info {
    public boolean isBST;
    public int maxSubBSTSize;
    public int min;
    public int max;

    public Info(boolean is, int size, int mn, int mx) {
        isBST = is;
        maxSubBSTSize = size;
        min = mn;
        max = mx;
    }
}

public static Info process(Node head) {
    if (head == null) {
        return null;
    }

    Info leftInfo = process(head.left);
    Info rightInfo = process(head.right);

    int min = head.value;
    int max = head.value;
    if (leftInfo != null) {
        min = Math.min(min, leftInfo.min);
        max = Math.max(max, leftInfo,max);
    }
    if (rightInfo != null) {
        min = Math.min(min, rightInfo.min);
        max = Math.max(max, rightInfo,max);
    }

    int maxSubBSTSize = 0;
    if (leftInfo != null) {
        maxSubBSTSize = leftInfo.maxSubBSTSize;
    }
    if (rightInfo != null) {
        maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
    }

    boolean isBST = false;
    if ((leftInfo == null ? true : leftInfo.isBST) 
        && (rightInfo == null ? true : rightInfo.isBST) 
        && (leftInfo == null ? true : leftInfo.max < head.value) 
        && (rightInfo == null ? true : rightInfo.min > head.value)) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                            + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                            + 1;
            isBST = true;
    }

    return new Info(isBST, maxSubBSTSize, min, max);
}