import java.util.Set;

public class lc1704 {
  class Solution {
    public boolean halvesAreAlike(String s) {
      char[] h1 = s.substring(0, s.length() / 2).toLowerCase().toCharArray();
      char[] h2 = s.substring(s.length() / 2, s.length()).toLowerCase().toCharArray();
      int h1VowelCount = 0;
      int h2VowelCount = 0;
      Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

      for (char c : h1) {
        if (vowels.contains(c)) {
          h1VowelCount++;
        }
      }

      for (char c : h2) {
        if (vowels.contains(c)) {
          h2VowelCount++;
        }
      }

      return h1VowelCount == h2VowelCount;
    }
  }
}