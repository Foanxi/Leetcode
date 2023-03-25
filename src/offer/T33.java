package offer;

public class T33 {
    boolean result = true;

    public static void main(String[] args) {
        System.out.println(new T33().verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }

    public boolean verifyPostorder(int[] postorder) {
        verify(postorder, 0, postorder.length-1);
        return result;
    }

    public void verify(int[] postorder, int l, int r) {
        if (l >= r) {
            return;
        }
        int index = traversal(postorder, l, r);
        verify(postorder, l, index-1);
        verify(postorder, index, r-1);
    }

    public int traversal(int[] postorder, int l, int r) {
        int pv = postorder[r];
        int index = r;
        for (int i = l; i < r; i++) {
            if (postorder[i] > pv) {
                index = i;
                break;
            }
        }
        for (int i = index; i < r; i++) {
            if (postorder[i] < pv) {
                result = false;
                break;
            }
        }
        return index;
    }
}
