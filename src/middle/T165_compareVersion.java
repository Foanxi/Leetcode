package middle;

/**
 * @author foanxi
 */
public class T165_compareVersion {
    public int compareVersion(String version1, String version2) {
        int v1 = 0;
        int v2 = 0;
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        while (v1 < ver1.length && v2 < ver2.length) {
            int num1 = Integer.parseInt(ver1[v1]);
            int num2 = Integer.parseInt(ver2[v2]);
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
            v1++;
            v2++;
        }
        if (v1 < ver1.length) {
            while (v1 < ver1.length) {
                if (Integer.parseInt(ver1[v1]) != 0) {
                    return 1;
                }
                v1++;
            }
        } else if (v2 < version2.length()) {
            while (v2 < ver2.length) {
                if (Integer.parseInt(ver2[v2]) != 0) {
                    return -1;
                }
                v2++;
            }
        }
        return 0;
    }
}
