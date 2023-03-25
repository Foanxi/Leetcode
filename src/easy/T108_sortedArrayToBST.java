package easy;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T108_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length);
    }

    public TreeNode createBST(int[] nums, int left, int right) {
        if (left < 0 || right > nums.length || left >= right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid);
        root.right = createBST(nums, mid + 1, right);
        return root;
    }
}
