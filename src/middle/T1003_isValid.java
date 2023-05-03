package middle;

public class T1003_isValid {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            sb.append(c);
            if (sb.length() >= 3 && "abc".equals(sb.substring(sb.length() - 3, sb.length()))) {
                sb.delete(sb.length() - 3, sb.length())
                ;
            }
        }
        return sb.length() == 0;
    }

    public boolean isValid2(String s) {
        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new T1003_isValid().isValid("aabcbc"));
    }
}
