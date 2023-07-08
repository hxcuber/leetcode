public class lc0013 {
  class Solution {
    public int romanToInt(String s) {
      int total = 0;
      char[] sArray = s.toCharArray();
      for (int i = 0; i < sArray.length; i++) {
        int nextIndex = i + 1 == sArray.length ? i : i + 1;
        int currVal = romValue(sArray[i]);
        int nextVal = romValue(sArray[nextIndex]);
        if (nextVal > currVal) {
          total += nextVal - 1;
          i = nextVal;
        } else {
          total += currVal;
        }
      }
        return total;
    }

    private int romValue(char c) {
      switch (c) {
        case 'I' -> {
          return 1;
        }
        case 'V' -> {
          return 5;
        }
        case 'X' -> {
          return 10;
        }
        case 'L' -> {
          return 50;
        }
        case 'C' -> {
          return 100;
        }
        case 'D' -> {
          return 500;
        }
        case 'M' -> {
          return 1000;
        }
      }
      return 0;
    }
  }
}