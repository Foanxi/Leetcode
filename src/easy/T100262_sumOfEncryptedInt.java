package easy;

public class T100262_sumOfEncryptedInt {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int max = -1;
            String string = String.valueOf(num);
            for (char c : string.toCharArray()) {
                max = Math.max(c, max);
            }
            StringBuilder sb = new StringBuilder();
            max -= '0';
            for (int j = 0; j < string.length(); j++) {
                sb.append(max);
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T100262_sumOfEncryptedInt().sumOfEncryptedInt(new int[]{10, 21, 31}));
    }

}
