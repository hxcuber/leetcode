public class lc0275 {
  class Solution {
    public int hIndex(int[] citations) {
      int count = 0;
      int h = citations.length;
      for (int i = citations.length - 1; i >= 0; i--) {
        if (citations[i] < h) {
          int max = citations[i] > count ? citations[i] : count;
          h = h < max ? h : max;
        }
        count++;
        if (count >= h) {
          return h;
        }
      }
      return 0;
    }
  }
}
