public class lc0274 {
  class Solution {
    // First try
    public int hIndex(int[] citations) {
      int h = 0;
      for (int i : citations) {
        int val = 0;
        if (i > h) {
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
    // Second try, tried to optimise, was on the right lines
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
    // Third try using bucket sort
    public int hIndex3(int[] citations) {
      int[] bucket = new int[citations.length + 1];
      for (int i = 0; i < citations.length + 1; i++) {
        bucket[i] = 0;
      }
      for (int i : citations) {
        if (i >= citations.length) {
          bucket[citations.length]++;
        } else {
          bucket[i]++;
        }
      }
      int count = 0;
      for (int j = citations.length; j >= 0 ; j--) {
        count += bucket[j];
        if (count >= j) {
          return j;
        }
      }
      return 0;
    }
  }
}