package offer;

public class T58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }
}
