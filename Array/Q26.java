class Q26 {
    public static int removeDuplicates(int[] nums) {
        int start = 0;
        int last = 1;
        while (last < nums.length){
            if (nums[start] == nums[last]){
                last++;
            }
            else {
                start++;
                nums[start] = nums[last];
                last++;
            }
        }
        return start+1;
    }
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }; // Input array
        int[] expectedNums = {0, 1, 2, 3, 4};
        // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}


    