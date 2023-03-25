package easy;

public class T944_minDeletionSize {
    public int minDeletionSize(String[] strs) {
        int del = 0;
        int col = 0;
        int row = 0;
        int widet = strs[0].length();
        int length = strs.length-1;
        for (col=0;col<widet;col++){
            for (row =0;row<length;row++){
                if (strs[row].charAt(col)>strs[row+1].charAt(col)){
                    del++;
                    break;
                }
            }
        }
        return del;
    }

    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        System.out.println(new T944_minDeletionSize().minDeletionSize(strs));
    }
}
