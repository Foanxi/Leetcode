package offer;

public class T65 {
    // 如果进行与&操作则可以求出是否需要进位
    // 正常情况下使用异或^操作则可以直接进行相加
    public int add(int a, int b) {
        while (b != 0){
            // 如果此时需要进位，则会被记录为相应的进位
            int carry = (a & b)<<1;
            // 进行正常地相加操作
            a ^= b;
            // b被赋值为之前未处理完的进位
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new T65().add(2, 3));
    }
}
