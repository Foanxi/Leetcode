package easy;

public class T14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String Prefix="";
        int Minlength = strs[0].length();
        for (int i=1;i<strs.length;i++){
            Minlength=Math.min(Minlength,strs[i].length());
        }
        for (int i=0;i<Minlength;i++){
            String temp="";
            boolean flag=true;
            for (int j=0;j<strs.length;j++){
                temp+=strs[j].charAt(i);
            }
            char tempchar= temp.charAt(0);
            for (int s=1;s<temp.length();s++){
                if (temp.charAt(s)!=tempchar){
                    flag=false;
                    break;
                }
                flag=true;
            }
            if (flag){
                Prefix+=tempchar;
            }else break;
        }
        return Prefix;
    }

    public static void main(String[] args) {
        String[] str={"a"};
        System.out.println(new T14_longestCommonPrefix().longestCommonPrefix(str));
    }
}
