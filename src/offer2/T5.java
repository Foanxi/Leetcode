package offer2;

public class T5 {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[26];
        // 首先建立掩码如a可以表示为25个0 1，b表示为24个0 10
        // 通过上述方式，可以表示每个单词中相应位置为1表示该字母存在于该单词中
        // 通过互相取与，即可得到
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                mask[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
