package offer;

public class T11 {
    public int minArray(int[] numbers) {
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
