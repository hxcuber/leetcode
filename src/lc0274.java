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