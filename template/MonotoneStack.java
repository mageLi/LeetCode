import java.util.*;

class MonotoneStack {
    //The typical paradigm for monotonous increase stack:
    public void increaseStack(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() > A[i]) {
                stack.pop();
            }
            stack.push(A[i]);
        }
    }
    //The typical paradigm for monotonous decrease stack:
    public void decreaseStack(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() < A[i]) {
                stack.pop();
            }
            stack.push(A[i]);
        }
    }
    /**
     *
     * find the left and right smaller than cur element
     * **/
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        if (heights == null || heights.length == 0) return 0;
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int curHeight = heights[stack.pop()];
                int lessPrevIndex = stack.peek();
                int len = i - lessPrevIndex - 1;
                res = Math.max(res,  curHeight * len);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int curHeight = heights[stack.pop()];
            int lessPrevIndex = stack.peek();
            int len = heights.length - lessPrevIndex - 1;
            res = Math.max(res,  curHeight * len);
        }
        return res;
    }
    /**
     *
     * find sliding window max or min
     * **/
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> q = new ArrayDeque<>(); // index
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst(); // remove out window element
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            } // remove smaller element
            q.offer(i); // 1 3 -1
            if (i >= k - 1)
                res[index++] = nums[q.peekFirst()];
        }
        return res;
    }
}
