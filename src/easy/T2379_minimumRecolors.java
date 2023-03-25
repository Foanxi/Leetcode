package easy;

public class T2379_minimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        char[] chars = blocks.toCharArray();
        while (right < k) {
            count += chars[right] == 'W' ? 1 : 0;
            right++;
        }
        while (right < chars.length) {
            count += chars[right] == 'W' ? 1 : 0;
            count -= chars[left] == 'W' ? 1 : 0;
            result = Math.min(result, count);
            left++;
            right++;
        }
        return result;
    }
}
