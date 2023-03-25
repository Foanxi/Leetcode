package easy;

public class T242_isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new T242_isAnagram().isAnagram(s, t));
    }
}
