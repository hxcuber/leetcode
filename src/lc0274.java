import java.util.Arrays;

public class lc0274 {
  class Solution {
    public int hIndex(int[] citations) {
      int h = 0;
      for (int i = 0; i < citations.length; i++) {
        int val = 0;
        for (int j = 0; j < citations.length; j++) {
          if (citations[j] >= citations[i]) {
            val++;
          }
        }
        if (val >= citations[i]) {
          h = h > citations[i] ? h : citations[i];
        }
      }
      return h;
    }
  }
}
