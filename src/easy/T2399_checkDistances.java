package easy;

public class T2399_checkDistances {
    public boolean checkDistances(String s, int[] distance) {
        int[] map = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0;i<charArray.length;i++) {
            int idx = charArray[i] - 'a';
            if (map[idx] != 0 && i - map[idx] != distance[i]){
                return false;
            }
            map[idx] = i + 1;
        }
        return true;
    }

    public boolean checkDistances2(String s, int[] distance) {
        for (int i = 0;i< distance.length;i++){
            char c = (char) ('a' + i);
            int index = s.indexOf(c);
            int index1 = s.lastIndexOf(c);
            if (s.contains(String.valueOf(c)) && index1 - index != distance[i]){
                return false;
            }
        }
        return true;
    }
}
