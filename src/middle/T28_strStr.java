package middle;

/**
 * @author hujinxu
 * @date 2023/7/22
 * @description
 */
public class T28_strStr {
    public int strStr(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == needleCharArray[0]) {
                int temp = i;
                for (int j = 0; j < needleCharArray.length; ++j, ++temp) {
                    if (temp >= haystack.length() || needleCharArray[j] != charArray[temp]) {
                        break;
                    }
                    if (j == needleCharArray.length - 1 && charArray[temp] == needleCharArray[j]) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new T28_strStr().strStr("a", "a"));
    }
}
