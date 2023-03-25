package middle;

public class T面试题5_2_printBin {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int dig = (int) num;
            sb.append(dig);
            num -= dig;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }

    public static void main(String[] args) {
        System.out.println(new T面试题5_2_printBin().printBin(0.625));
    }
}
