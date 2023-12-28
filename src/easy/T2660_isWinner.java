package easy;

public class T2660_isWinner {
    public int isWinner(int[] player1, int[] player2) {
        boolean have1 = false;
        int last1 = 0;
        boolean have2 = false;
        int last2 = 0;
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < player1.length; i++) {
            score1 += have1 ? player1[i] * 2 : player1[i];
            if (player1[i] == 10) {
                have1 = true;
                last1 = 2;
            } else if (last1 == 0) {
                have1 = false;
            }
            last1--;
            score2 += have2 ? player2[i] * 2 : player2[i];
            if (player2[i] == 10) {
                have2 = true;
                last2 = 2;
            } else if (last2 == 0) {
                have2 = false;
            }
            last2--;
        }
        return score1 > score2 ? 1 : score1 == score2 ? 0 : 2;
    }
}
