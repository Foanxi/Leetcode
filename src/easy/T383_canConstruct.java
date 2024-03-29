package easy;

public class T383_canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] word = new int[26];
        for (char c : magazine.toCharArray()) {
            word[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            word[c - 'a']--;
        }
        for (int t : word) {
            if (t < 0) return false;
        }
        return true;
    }
}
