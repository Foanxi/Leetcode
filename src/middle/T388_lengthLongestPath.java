package middle;

import java.util.Stack;

public class T388_lengthLongestPath {
    public int lengthLongestPath(String input) {
        int length=0;
        int pos=0;
        Stack<Integer> stack = new Stack<>();

        while (pos<input.length()){
            int depth=1;
            while (input.charAt(pos) == '\t'){
                depth++;
                pos++;
            }
            boolean isFile = false;
            int temp=0;
            while (pos<input.length()&&input.charAt(pos)!='\n'){
                if (input.charAt(pos)=='.'){
                    isFile=true;
                }
                temp++;
                pos++;
            }
            pos++;
            while (stack.size()>=depth){
                stack.pop();
            }
            if (!stack.isEmpty()){
                temp+=stack.peek()+1;
            }
            if (isFile){
                length=Math.max(length,temp);
            }else stack.push(temp);
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(new T388_lengthLongestPath().lengthLongestPath(s));
    }
}
