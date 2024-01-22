package middle;

public class T670_maximumSwap {
    public int maximumSwap(int num) {
        String sb = String.valueOf(num);
        char[] charArray = sb.toCharArray();
        for (int i = 0; i < sb.length(); i++) {
            if (charArray[i] == '9') {
                continue;
            }
            char max = 0;
            int index = 0;
            for (int j = i + 1; j < sb.length(); j++) {
                if (charArray[j] >=  max) {
                    max = charArray[j];
                    index = j;
                }
            }
            if (max > charArray[i]) {
                char c = charArray[i];
                charArray[i] = max;
                charArray[index] = c;
                break;
            }
        }
        return Integer.parseInt(new String(charArray));
    }
}
