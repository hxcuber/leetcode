import java.util.Map;

import static java.util.Map.entry;

public class lc0012 {
  class Solution {
    public String intToRoman(int num) {
      StringBuilder stringBuilder = new StringBuilder();
      Map<Integer, Character> numToRomChar = Map.ofEntries(
          Map.entry(1, 'I'),
          Map.entry(5, 'V'),
          Map.entry(10, 'X'),
          Map.entry(50, 'L'),
          Map.entry(100, 'C'),
          Map.entry(500, 'D'),
          Map.entry(1000, 'M')
      );

      while (num >= 1000) {
        num -= 1000;
        stringBuilder.append('M');
      }
      // PRE: num < 1000
      for (int i = 2; i >= 0; i--) {
        int currExponent = (int) Math.pow(10, i);
        int currNum = num / currExponent;
        if (currNum == 9) {
          num -= 9 * currExponent;
          stringBuilder.append(numToRomChar.get(1 * currExponent)).append(numToRomChar.get(10 * currExponent));
        } else if (currNum == 4) {
          num -= 4 * currExponent;
          stringBuilder.append(numToRomChar.get(1 * currExponent)).append(numToRomChar.get(5 * currExponent));
        } else {
          if (currNum / 5 == 1) {
            num -= 5 * currExponent;
            stringBuilder.append(numToRomChar.get(5 * currExponent));
          }

          while (num >= currExponent) {
            num -= currExponent;
            stringBuilder.append(numToRomChar.get(1 * currExponent));
          }
        }
      }
      return stringBuilder.toString();
    }
  }
}