package easy;

public class T541_reverseStr {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int length = s.length();
        while (i < length){
            StringBuilder temp = new StringBuilder();
            int startk = Math.min(i + k, length);
            int secondk = Math.min(i + 2 * k, length);
            temp.append(s, i, startk);
            res.append(temp.reverse());
            if (startk < secondk)res.append(s, startk, secondk);
            i += k*2;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T541_reverseStr().reverseStr("hello", 2));
    }
}