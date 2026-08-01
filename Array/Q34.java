public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] returned = { -1, -1 };

        for (int i = 0; i < returned.length; i++) {
            int start = 0;
            int last = nums.length - 1;
            while (start <= last) {
                int mid = start + (last - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] == target) {
                    returned[i] = mid;
                    if (i == 0) {
                        last = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    last = mid - 1;
                }
            }
        }
        return returned;
    }
}