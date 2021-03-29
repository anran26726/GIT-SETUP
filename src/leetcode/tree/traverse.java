/**
 * 完全二叉树
 * 先序遍历
 * 中序遍历
 * 后序遍历
 */

public class Node {
    v value;
    Node left;
    Node right;
}

public static void traverse(Node head) {
    if (head == null) {
        return;
    }

    // print在这里，先序
    traverse(head.left);
    // print在这里，中序
    traverse(head.right);
    // print在这里，后序
}

// 递归改非递归：压栈 （栈：*逆序）
public static void preTraverse(Node head) {
    if (head != null) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null) { // 先序遍历一定是先压右节点，不然弹出的时候就不对了
                stack.push(head.right);
            } 
            if (stack.left != null) {
                stack.push(head.left);
            }
        }
    }
}

public static void posTraverse1(Node head) {
    if (head != null) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>(); //辅助栈

        stack1.push(head);
        while (!stack1.isEmpty()) { //头左右逆序就是后序遍历
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack2.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            stack2.pop();
        }
    }
}

public static void inTraverse(Node head) {
    if (head != null) {
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                head = head.right;
            }
        }
    }
}

// 只用一个栈实现后序遍历（不用辅助栈）
public static void posTraverse2(Node head) {
    if(head != null) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        Node cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek(); // peek是指向栈中最上方的一个值，并没有弹出
            if (cur.left != null && head != cur.left && head != cur.right) {
                stack.push(cur.left);
            } else if (c.right != null && head != cur.right) {
                stack.push(cur.right);
            } else {
                head = cur;
            }

        }
    }
}