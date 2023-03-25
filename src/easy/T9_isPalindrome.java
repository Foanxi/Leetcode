package easy;

public class T9_isPalindrome {
    public boolean isPalindrome(int x) {
            if (x<0)return false;
        int length = 0;
        while (x/(long) Math.pow(10,length)!=0){
            length++;
        }
        if (length==1)return true;
        int[] check = new int[length];
        for (int i=check.length-1;i>=0;i--){
            check[i]=x%10;
            x/=10;
        }
        for (int right = check.length-1,left = 0;right>left;right--,left++){
            if (check[left]!=check[right])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T9_isPalindrome().isPalindrome(2147483647));
    }
}
