package middle;

/**
 * @author foanxi
 */
public class T2337_canChange {
    public boolean canChange(String start, String target) {
        int n = target.length();
        char[] targetArray = target.toCharArray();
        char[] startArray = start.toCharArray();

        int index1 = 0;
        int index2 = 0;
        while (index1 < n && index2 < n) {
            while (index1 < n && startArray[index1] == '_') {
                index1++;
            }
            while (index2 < n && targetArray[index2] == '_') {
                index2++;
            }
            if (index1 < n && index2 < n) {
                if (startArray[index1] != targetArray[index2]) {
                    return false;
                } else if (startArray[index1] == 'L' && index1 < index2) {
                    return false;
                } else if (startArray[index1] == 'R' && index1 > index2) {
                    return false;
                }
                index1++;
                index2++;
            }
        }
        while (index1 < n) {
            if (startArray[index1] != '_') {
                return false;
            }
            index1++;
        }
        while (index2 < n) {
            if (targetArray[index2] != '_') {
                return false;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T2337_canChange().canChange("__LL", "LL__"));
    }
}
