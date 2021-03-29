/**
* 1. array, partition
* 2. 六个指针
*/

/** 1. */
public static Node listPartition1(Node head, int pivot) {
    if (head == null) {
        return head;
    }

    // 只是为了知道array的长度
    Node cur = head;
    int i = 0;
    while (cur != null) {
        i++;
        cur = cur.next;
    }
    
    // 创建i长度的array，并把每一个节点存入array
    Node[] nodeArr = new Node[i];
    i = 0；
    cur = head;
    for (i = 0; i != nodeArr.length; i++) {
        nodeArr[i] = cur;
        cur = cur.next; 
    }

    // partition
    arrPartition(nodeArr, pivot);

    // 把数组里的值从左往右依次串起来
    for (i = 1; i != nodeArr.length; i++) {
        nodeArr[i - 1].next = nodeArr[i];
    }
    nodeArr[i - 1].next = null;
    return nodeArr[0];
}

public static void arrPartition(Node[] nodeArr, int pivot) {
    int small = -1;
    int big = nodeArr.length;
    int index = 0;

    while (small <= big ) {
        while 
    }

}