import java.util.Arrays;

public class lc0274 {
  class Solution {
    public int hIndex(int[] citations) {
      int h = 0;
      for (int i = 0; i < citations.length; i++) {
        int val = 0;
        if (citations[i] != 0 && citations[i] > h) {
          for (int j = 0; j < citations.length; j++) {
            if (citations[j] >= citations[i]) {
              val++;
            }
          }
        }
        int min = val < citations[i] ? val : citations[i];
        h = h > min ? h : min;
      }
      return h;
    }
  }
}