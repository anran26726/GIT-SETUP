/**
 完全二叉树
 满，或从左到右依次变满的树

BFS
 1. 遇到的每一个节点，如果有右孩子但没有左孩子（有右无左），false（一定不是完全二叉树）
 2. 当遇到第一个左右孩子不双全的节点，后续遇到的所有节点都必须是叶子节点（即无孩子）

DFS
 1. 满二叉树（无缺口）
 2. 有缺口，缺口位置在哪儿？
    1. 左树有缺口，且没有去到右树 （左树是完全二叉树，右树是满二叉树，且左树高度比右树大1）
    2. 左树无缺口，且去到右树 （左树是满二叉树，右树是满二叉树，左树高度比右树大1）
    3. 右树有缺口 （左树是满二叉树，右树是满二叉树，左树高度和右树高度相等）
 */

public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBTbfs(Node head) {
        if (head == null) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();

        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);

        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            if ((leaf && !(l == null && r == null)) || (l == null && r != null)) {
                return false;
            }

            if (l !== null) {
                queue.add(l);
            } 

            if (r != null) {
                queue.add(r);
            }

            if (l == null || r == null) {
                leaf = true;
            }
        }

        return true;
    }

    public static boolean isCBTdfs(Node head) {
        if (head == null) {
            return true;
        }

        return process(head).isCBT;
    }

    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean full, boolean cbt, int h) {
            isFull = full;
            isCBT = cbt;
            height = h;
        }
    }

    public static Info process(Node head) {
        if (head == null) {
            return new Info(true, true, 0);
        }

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else {
            if (leftInfo.isCBT && rightInfo.isCBT) {
                if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }

                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
                    isCBT = true;
                }

                if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
                    isCBT = true;
                }
            }
        }

        return new Info(isFull, isCBT, height);
    }
}