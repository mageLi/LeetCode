import java.util.*;

public class Print {
    /**
     * print Deque
     *
     * **/
    private void printDeque(Deque<Character> q) {
        System.out.println();
        System.out.println("--------------------------");
        int size = q.size();
        int i = 0;
        while (i++ < size) {
            if (i == 0) {
                System.out.print(q.peekFirst());
            } else {
                System.out.print("," + q.peekFirst());
            }
            q.addLast(q.pollFirst());
        }
        System.out.println();
        System.out.println("--------------------------");
    }
    /**
     * printList
     *
     * **/
    private void printList(List<Integer> list) {
        System.out.println();
        System.out.println("--------------------------");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.print(list.get(i));
            } else {
                System.out.print("," + list.get(i));
            }
        }
        System.out.println();
        System.out.println("--------------------------");
    }
    /**
     * printArray
     *
     * **/
    private void printArray(int[] nums) {
        System.out.println();
        System.out.println("--------------------------");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print("," + nums[i]);
            }
        }
        System.out.println();
        System.out.println("--------------------------");
    }
}
