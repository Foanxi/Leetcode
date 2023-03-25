package middle;

import common.TreeNode;

/**
 * @author foanxi
 */
public class T654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = traversal(nums, begin, index);
        root.right = traversal(nums, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        new T654_constructMaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

}
