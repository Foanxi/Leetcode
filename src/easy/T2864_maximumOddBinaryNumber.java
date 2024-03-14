package easy;

public class T2864_maximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        int num1 = 0;
        for (char c :charArray){
            if (c == '1'){
                num1++;
            }
        }
        int num0 = s.length() - num1;
        while (num1>1){
            sb.append('1');
            num1--;
        }
        while (num0>0){
            sb.append('0');
            num0--;
        }
        return sb.append('1').toString();
    }
}
