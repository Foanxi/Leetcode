package middle;

public class T1823_findTheWinner {
    public int findTheWinner(int n, int k) {
        int[] quene = new int[n];
        int[] result = new int[n];
        int resultkey = 0;

        //初步给数组赋值
        for (int i = 0; i < quene.length; i++) {
            quene[i] = i + 1;
        }

        int key = (k - 1) % quene.length;
        //开始循环计数找出最后一个人
        while (n > 0) {
            if (quene[key] != 0) {
                result[resultkey] = quene[key];
                quene[key] = 0;
                key++;
                resultkey++;
                n--;
            }
            if (quene[key] == 0) {
                key++;
                continue;
            }
            if (n == 0) break;
            key = (k + key - 1) % quene.length;
        }
        return result[result.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new T1823_findTheWinner().findTheWinner(5, 2));
    }
}
