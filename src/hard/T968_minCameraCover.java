package hard;

import common.TreeNode;

public class T968_minCameraCover {

    int result = 0;

    public int minCameraCover(TreeNode root) {
        // 此时root依旧没有被覆盖，单独加1
        if (traversal(root) == 0) {
            result++;
        }
        return result;
    }

    /**
     * 回溯处理
     *
     * @param cur 当前节点
     * @return 0表示没有覆盖，1表示当前此处有摄像头，2表示有被监控覆盖
     */
    public int traversal(TreeNode cur) {
        // 当前节点为叶子节点
        if (cur == null) {
            return 2;
        }

        int left = traversal(cur.left);
        int right = traversal(cur.right);

        // 由于从后往前，两边都覆盖了说明摄像头的范围已经是达到了顶层，接下来无法再覆盖，返回无覆盖
        if (left == 2 && right == 2) {
            return 0;
        }
        // 由于从后往前，如果只有一个被覆盖，另一个可能为空节点，此时该节点为叶子节点的父亲，表示当前这个应该为摄像头
        // 此处可以注意已经排除了同时为2的情况
        else if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        // 表示当前节点的左边或右边有一个摄像头，此时直接返回已经被覆盖
        else {
            return 2;
        }
    }
}
