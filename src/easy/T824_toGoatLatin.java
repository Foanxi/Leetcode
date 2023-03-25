package easy;

import java.util.ArrayList;
import java.util.List;

public class T824_toGoatLatin {
    public String toGoatLatin(String sentence) {
        StringBuilder Goat=new StringBuilder();
        String[] s = sentence.split(" ");
        for (int i=0;i<s.length;i++){
            StringBuilder stringBuilder = new StringBuilder(s[i]);
            List<Character> characters = new ArrayList<>();
            characters.add('a');
            characters.add('e');
            characters.add('i');
            characters.add('o');
            characters.add('u');
            characters.add('A');
            characters.add('E');
            characters.add('I');
            characters.add('O');
            characters.add('U');
            if (!characters.contains(s[i].charAt(0))){
                stringBuilder.append(s[i].charAt(0));
                stringBuilder.deleteCharAt(0);
            }
            stringBuilder.append("ma");
            for (int j=0;j<=i;j++){
                stringBuilder.append("a");
            }
            if (i!=s.length-1) {
                Goat.append(stringBuilder+" ");
            }else Goat.append(stringBuilder);
        }
        return Goat.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T824_toGoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
