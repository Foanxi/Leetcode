package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T1993_LockingTree {
    static class LockingTree {

        List<Integer>[] children;
        int[] lockUser;
        int[] parent;

        public LockingTree(int[] parent) {
            int n = parent.length;
            this.children = new List[n];
            this.lockUser = new int[n];
            this.parent = parent;
            Arrays.fill(lockUser, -1);
            for (int i = 0; i < n; i++) {
                children[i] = new ArrayList<>();
            }
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    children[parent[i]].add(i);
                }
            }
        }

        public boolean lock(int num, int user) {
            if (lockUser[num] != -1) {
                return false;
            }
            lockUser[num] = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if (lockUser[num] == user) {
                lockUser[num] = -1;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if (lockUser[num] == -1 && findFatherLock(num) && dfsFindLock(num)) {
                lock(num, user);
                return true;
            }
            return false;
        }


        /**
         * 深度遍历将所有孩子节点解锁
         *
         * @param num 当前节点
         */
        public boolean dfsFindLock(int num) {
            boolean res = lockUser[num] != -1;
            lockUser[num] = -1;
            // 遍历孩子节点
            for (Integer i : children[num]) {
                res |= dfsFindLock(i);
            }
            return res;
        }

        public boolean findFatherLock(int num) {
            num = parent[num];
            while (num != -1) {
                if (lockUser[num] != -1) {
                    return false;
                }
                num = parent[num];
            }
            return true;
        }

    }

    public static void main(String[] args) {
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 3, 1, 0});
        System.out.println(lockingTree.upgrade(4, 5));
//        System.out.println(lockingTree.unlock(2, 3));
//        System.out.println(lockingTree.lock(2, 2));
//        System.out.println(lockingTree.upgrade(0, 1));
//        System.out.println(lockingTree.lock(0, 1));
    }
}
