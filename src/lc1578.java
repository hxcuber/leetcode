import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class lc1578 {
  class Solution {
    public int minCost(String colors, int[] neededTime) {
      char[] colorsArray = colors.toCharArray();
      int totalTime = Arrays.stream(neededTime).sum();
      for (int i = 0; i < colorsArray.length; i++) {
        int maxIndex = i;
        int x = 0;
        while (x < (colors.length() - i) && colors.charAt(x + i) == colors.charAt(i)) {
          maxIndex = neededTime[maxIndex] > neededTime[x + i] ? maxIndex : x + i;
          x++;
        }
        totalTime -= neededTime[maxIndex];
        i += x - 1;
      }
      return totalTime;
    }
  }
}