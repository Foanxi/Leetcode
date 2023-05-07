package nowcoder;

public class BM18 {
    public boolean Find(int target, int[][] array) {
        return binaryFind(target, array, 0, array.length, 0, array[0].length);
    }

    public boolean binaryFind(int target, int[][] array, int xLeft, int xRight, int yLeft, int yRight) {
        if (xLeft >= xRight || yLeft >= yRight) {
            return false;
        }
        // 直接寻找矩阵的mid
        int xMid = (xRight - xLeft) / 2 + xLeft;
        int yMid = (yRight - yLeft) / 2 + yLeft;
        if (array[xMid][yMid] == target) {
            return true;
        } else if (array[xMid][yMid] < target) {
            if (binaryFind(target, array, xMid + 1, xRight, yLeft, yRight)) {
                return true;
            }
            return binaryFind(target, array, xLeft, xMid + 1, yMid + 1, yRight);
        } else {
            if (binaryFind(target, array, xLeft, xMid, yLeft, yRight)) {
                return true;
            }
            return binaryFind(target, array, xMid, xRight, yLeft, yMid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BM18().Find(7, new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}));
    }
}
