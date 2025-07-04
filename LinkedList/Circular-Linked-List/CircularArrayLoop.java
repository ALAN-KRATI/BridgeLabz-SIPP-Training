class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = i;
            boolean isForward = nums[i] > 0;

            while (true) {
                slow = getNextIndex(nums, isForward, slow);
                fast = getNextIndex(nums, isForward, fast);
                if (fast != -1) {
                    fast = getNextIndex(nums, isForward, fast);
                }
                if (slow == -1 || fast == -1 || slow == fast) break;
            }

            if (slow != -1 && slow == fast) return true;

            slow = i;
            int val = nums[i];
            while ((nums[slow] > 0) == isForward) {
                int next = getNextIndex(nums, isForward, slow);
                nums[slow] = 0;
                slow = next;
                if (slow == -1) break;
            }
        }
        return false;
    }

    private static int getNextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean direction = nums[currentIndex] > 0;
        if (direction != isForward) return -1;
        int nextIndex = (currentIndex + nums[currentIndex]) % nums.length;
        if (nextIndex < 0) nextIndex += nums.length;
        if (nextIndex == currentIndex) return -1;
        return nextIndex;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};
        System.out.println("Has circular loop: " + circularArrayLoop(nums));
    }
}