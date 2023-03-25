package middle;

public class T1576_findLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        // 先找右端点满足递减的情况删掉左端点元素个数最小的可能
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        // 如果到达最左边，则表示数组递增，可以删除全部
        if (right == 0) {
            return 0;
        }
        // 否则现在可以暂时记录为删除当前右指针指向的元素的前面所有元素
        int min = right;
        // 枚举所有左端点
        for (int left = 0; left < arr.length; left++) {
            while (right < arr.length && arr[left] > arr[right]){
                right++;
            }
            min = Math.min(min,right-left-1);
            if (arr[left] > arr[left + 1]){
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new T1576_findLengthOfShortestSubarray().findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    }
}
