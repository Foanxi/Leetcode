package easy;

/**
 * @author foanxi
 */
public class T2383_minNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        int curEnergy = initialEnergy;
        int curExp = initialExperience;
        for (int i = 0; i < energy.length; i++) {
            if (curEnergy <= energy[i]) {
                result += energy[i] - curEnergy + 1;
                curEnergy = energy[i] + 1;
            }
            if (curExp <= experience[i]) {
                result += experience[i] - curExp + 1;
                curExp = experience[i] + 1;
            }
            curExp += experience[i];
            curEnergy -= energy[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new T2383_minNumberOfHours().minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }
}
