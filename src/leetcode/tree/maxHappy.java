/**
 * 多叉树
 * 如果x，则x的child都不来
 */


class Employee {
    public int happy;
    List<Employee> subordinates; //直接下级

    public Employee(int h) {
        happly = h;
        subordinates = new ArrayList<>();
    }
}

public static class Info {
    public int yes; // 头节点来，整棵树最大快乐值
    public int no; // 头节点不来，整棵树最大快乐值

    public Info(int y, int n) {
        yes = y;
        no = n;
    }
}

public static Info process(Employee x) {
    if (x.subordinates.isEmpty()) {
        return new Info(x.happy, 0);
    }

    int yes = x.happy;
    int no = 0;
    for (Employee subordinate : x.subordinates) {
        Info subordinateInfo = process(subordinate);
        yes += subordinateInfo.no;
        no += Math.max(subordinateInfo.yes, subordinateInfo.no);
    }

    return new Info(yes, no);
}

