package easy;

public class T859_buddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        int diff = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] goalChar = goal.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count1[chars[i] - 'a']++;
            count2[goalChar[i] - 'a']++;
            if (chars[i] != goalChar[i]) {
                diff++;
            }
        }
        boolean flag = false;
        for (int i=0;i<26;i++){
            if (count1[i] != count2[i]){
                return false;
            } else if (count1[i] >= 2) {
                flag = true;
            }
        }
        return diff == 2 || (diff == 0 && flag);
    }
}
