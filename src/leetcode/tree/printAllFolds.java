/** 打印折痕方向 */

public class PaperFolding {
    
    public static void printAllFolds(int N) {
        printProcess(1, N ,true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }

        printProcess(i+1, N, true);
        system.out.println(down ? concave : convex)
        printProcess(i+1, N, false);
    }
    
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}


