package easy;

public class T57_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] word = s.split(" +");
        return word[word.length-1].length();
    }

    public static void main(String[] args) {
        String s="Hello      w o r ld  ";
        System.out.println(new T57_lengthOfLastWord().lengthOfLastWord(s));
    }
}
