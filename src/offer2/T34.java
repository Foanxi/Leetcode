package offer2;

public class T34 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.min(words[i].length(), words[i + 1].length());
            boolean vaild = false;
            for (int j = 0; j < len; j++) {
                if (map[words[i].charAt(j) - 'a'] < map[words[i + 1].charAt(j) - 'a']) {
                    vaild = true;
                    break;
                } else if (map[words[i].charAt(j) - 'a'] > map[words[i + 1].charAt(j) - 'a']) {
                    return false;
                }
            }
            if (!vaild){
                if (words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
