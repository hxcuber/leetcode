public class lc2038 {
  public class Solution {
    public boolean winnerOfGame(String colors) {
      if (colors.length() <= 2) {
        return false;
      }
      int[] count = {0,0};
      for (int i = 0; i < colors.length(); i++) {
        boolean alice = colors.charAt(i) == 'A';
        int x = 0;
        while (x < (colors.length() - i) && colors.charAt(x + i) == colors.charAt(i)) {
          x++;
        }
        count[alice ? 0 : 1] += x < 2 ? 0 : x - 2;
        i += (x - 1);
      }
      return count[0] > count[1];
    }
  }
}
