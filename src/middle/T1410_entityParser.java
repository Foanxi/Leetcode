package middle;

import java.util.HashMap;
import java.util.Map;

public class T1410_entityParser {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for (String s : map.keySet()) {
            text = text.replaceAll(s, map.get(s));
        }
        text = text.replaceAll("&amp;", "&");
        return text;
    }
}
