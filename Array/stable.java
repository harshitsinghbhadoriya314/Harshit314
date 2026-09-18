class stable {
    public int firstStableIndex(int[] nums, int k) {
        int score = k;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int help = nums.length - 1;
        if (nums.length < 1){
            return 0;
        }
        int index = 0;
        while (index < nums.length) {
            for (int i = 0; i < nums.length - help; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    System.out.println(max);
                }
            }
            for (int j = nums.length - help - 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    System.out.println(min);
                }
            }
            score = max - min;
            System.out.println(score);
            if (score <= k) {
              return index;
            }
            help--;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            index++;
        }
        return -1;
    }
}