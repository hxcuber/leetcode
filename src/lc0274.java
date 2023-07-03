import java.util.Arrays;

public class lc0274 {
  class Solution {
    public int hIndex(int[] citations) {
      int h = 0;
      for (int i : citations) {
        int val = 0;
        if (i != 0 && i > h) {
          for (int j : citations) {
            if (j >= i) {
              val++;
            }
          }
        }
        int min = val < i ? val : i;
        h = h > min ? h : min;
      }
      return h;
    }
    public int hIndex2(int[] citations) {
      for (int h = 0; h < citations.length + 1; h++) {
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
          if (citations[i] >= h) {
            count++;
          }
        }
        if (h > count) {
          return h - 1;
        }
      }
      return citations.length;
    }
  }
}