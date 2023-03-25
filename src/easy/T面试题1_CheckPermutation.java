package easy;

import java.util.ArrayList;
import java.util.List;

public class T面试题1_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int length = s1.length();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            characters.add(s1.charAt(i));
        }
        for (int j = 0; j < length; j++) {
            characters.remove((Character) s2.charAt(j));
        }
        return characters.size()==0;
    }

    public static void main(String[] args) {
        System.out.println(new T面试题1_CheckPermutation().CheckPermutation("abc", "bca"));
    }
}
