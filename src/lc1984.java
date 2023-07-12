import java.util.Arrays;

public class lc1984 {
  class Solution {
    public int minimumDifference(int[] nums, int k) {
      if (k <= 1) {
        return 0;
      }

      Arrays.sort(nums);
      int min = Integer.MAX_VALUE;
      for (int i = nums.length - 1; i >= k - 1; i--) {
        min = min < nums[i] - nums[i - k + 1] ? min : nums[i] - nums[i - k + 1];
      }
      return min;
    }
  }
}