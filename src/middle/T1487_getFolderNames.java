package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1487_getFolderNames {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) {
            if (map.containsKey(names[i])) {
                int k = map.get(names[i]);
                while (map.containsKey(addSuffix(names[i], k))) {
                    k++;
                }
                res[i] = addSuffix(names[i], k);
                map.put(names[i], k + 1);
                map.put(addSuffix(names[i], k), 1);
            } else {
                res[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        StringBuilder sb = new StringBuilder(name);
        sb.append("(").append(k).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] names = {"gta", "gta(1)", "gta", "avalon"};
        System.out.println(Arrays.toString(new T1487_getFolderNames().getFolderNames(names)));
    }
}
