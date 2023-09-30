package easy;

/**
 * @author foanxi
 */
public class T605_canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] != 1;
        }
        int index = 0;
        while (n > 0 && index < flowerbed.length) {
            if (index == 0) {
                if (flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
                    flowerbed[index] = 1;
                    n--;
                }
            } else if (index == flowerbed.length - 1) {
                if (flowerbed[index] == 0 && flowerbed[index - 1] == 0) {
                    n--;
                }
            } else if (flowerbed[index] == 0 && flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0) {
                n--;
                flowerbed[index] = 1;
            }
            index++;
        }
        return n == 0;
    }
}
