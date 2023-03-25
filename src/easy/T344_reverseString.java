package easy;

public class T344_reverseString {
    public void reverseString(char[] s) {
        for(int left=0,right=s.length-1;left <= right;left++,right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        char[]s = {'h','e','l','l','o','h'};
        new T344_reverseString().reverseString(s);
        System.out.println(s);
    }
}
