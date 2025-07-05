import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices outside current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();

            // Remove smaller values from the end
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);

            // Add to result once window is formed
            if (i >= k - 1)
                result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = obj.maxSlidingWindow(nums, k);

        System.out.print("Sliding Window Maximums: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
