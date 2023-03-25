package offer;

public class T58_1 {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=s1.length-1;i>=1;i--){
            if (s1[i].isEmpty()){
                continue;
            }
            sb.append(s1[i]).append(" ");
        }
        return sb.append(s1[0]).toString();
    }
}
