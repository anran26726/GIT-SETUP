/** 
 * 给定一颗二叉树的头节点head，任何两个节点之间都存在距离
 * 返回整棵二叉树的最大距离
 */


public static int maxDistance(Node head) {
    return process(head).maxDistance;
}

public static class Info {
    public int maxDistance;
    public int height;

    public Info(int dis, int h) {
        maxDistance = dis;
        height = h;
    }
}

public static Info process(Node head) {
    if (head == null) {
        return new Info(0, 0);
    }

    Info leftInfo = process(head.left);
    Info rightInfo = process(head.right);
    int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);

    return new Info(maxDistance, height);
}