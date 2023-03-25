package easy;

import java.util.HashMap;
import java.util.Map;

public class T13_romanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i=0;i<s.length()-1;i++){
            if (map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else sum += map.get(s.charAt(i));
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T13_romanToInt().romanToInt("MCMXCIV"));
    }
}
