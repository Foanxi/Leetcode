package middle;

public class T299_getHint {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] mapA = new int[10];
        int[] mapB = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            }
            mapA[guess.charAt(i) - '0']++;
            mapB[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(mapB[i], mapA[i]);
        }
        return a + "A" + (b - a) + "B";
    }
}
