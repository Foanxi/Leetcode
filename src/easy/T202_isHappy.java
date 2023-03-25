package easy;

import java.util.HashSet;
import java.util.Set;

public class T202_isHappy {
    public boolean isHappy(int n) {
        int sum=n;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(sum)&&sum!=1){
            set.add(n);
            sum=0;
            while (n>0){
                int d=n%10;
                sum+=(d*d);
                n/=10;
            }
            n=sum;
        }
        return !set.contains(sum);
    }

    public static void main(String[] args) {
        System.out.println(new T202_isHappy().isHappy(19));
    }
}
