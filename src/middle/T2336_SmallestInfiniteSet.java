package middle;

import java.util.*;

public class T2336_SmallestInfiniteSet {

    public static void main(String[] args) {
        T2336_SmallestInfiniteSet set = new T2336_SmallestInfiniteSet();
        set.popSmallest();
        set.addBack(1);
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
    }

    TreeSet<Integer> remove;

    TreeSet<Integer> addBack;

    public T2336_SmallestInfiniteSet() {
        remove = new TreeSet<>(((o1, o2) -> o2 - o1));
        addBack = new TreeSet<>(((o1, o2) -> o1 - o2));
    }

    public int popSmallest() {
        if (!addBack.isEmpty()) {
            Integer i = addBack.pollFirst();
            remove.add(i);
            return i;
        }
        if (remove.isEmpty()) {
            remove.add(1);
            return 1;
        } else {
            int first = remove.first() + 1;
            remove.add(first);
            return first;
        }
    }

    public void addBack(int num) {
        if (remove.contains(num)) {
            addBack.add(num);
        }
    }
}
