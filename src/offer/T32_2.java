package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if (cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
                temp.add(cur.val);
            }
            res.add(temp);
        }
        return res;
    }
}
