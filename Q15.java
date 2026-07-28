import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Q15 {
    public List<List<Integer>> go(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length -2) {
            int start = i + 1;
            int last = nums.length - 1;
            while (start < last) {
                int sum = nums[start] + nums[last] + nums[i];
                if (sum == 0) {
                    List<Integer> obj = new ArrayList<>();
                    obj.add(nums[i]);
                    obj.add(nums[start]);
                    obj.add(nums[last]);
                    ans.add(obj);
                    start++;
                    last--;
                }
                else if (sum > 0) {
                    last--;
                }
                else {
                    start++;
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q15 val = new Q15();
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(val.go(arr));
    }
}
