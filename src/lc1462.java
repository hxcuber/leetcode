import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc1462 {
  class Solution{
    // first try
    // this is slow because its running the dfs for every query, so there is a lot of repeated work
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      // basically dfs
      // find if there a path in prerequisites that matches the start and finish of queries
      return Arrays.stream(queries).map(query -> dfs(numCourses, prerequisites, query[0], query[1], new HashSet<>())).toList();
    }

    // second try
    // calculate transitive closure first, then look up queries
    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
      Set<List<Integer>> closure = transClosure(numCourses, prerequisites);
      return Arrays.stream(queries).map(query -> closure.contains(List.of(query[0], query[1]))).toList();
    }

    public List<Boolean> checkIfPrerequisite3(int numCourses, int[][] prerequisites, int[][] queries) {
      boolean[][] adjMatrix = new boolean[numCourses][numCourses];

      for (int i = 0; i < numCourses; i++) {
        for (int j = 0; j < numCourses; j++) {
          adjMatrix[i][j] = false;
        }
      }

      for (int[] edge: prerequisites) {
        adjMatrix[edge[0]][edge[1]] = true;
      }

      for (int k = 0; k < numCourses; k++) {
        for (int i = 0; i < numCourses; i++) {
          for (int j = 0; j < numCourses; j++) {
            adjMatrix[i][j] = adjMatrix[i][j] || (adjMatrix[i][k] && adjMatrix[k][j]);
          }
        }
      }

      return Arrays.stream(queries).map(query -> adjMatrix[query[0]][query[1]]).toList();
    }

    private Set<List<Integer>> transClosure(int numCourses, int[][] prerequisites) {
      // [v, k]
      // each key contains the values that can reach it
      Set<List<Integer>> ret = new HashSet<>();
      Map<Integer, Set<Integer>> map = new HashMap<>();
      for (int i = 0; i < numCourses; i++) {
        map.put(i, new HashSet<>());
      }
      for (int[] edge : prerequisites) {
        map.get(edge[1]).add(edge[0]);
        map.get(edge[1]).addAll(map.get(edge[0]));
        List<List<Integer>> toBeAdded = new ArrayList<>();
        for (int key : map.keySet()) {
          for (int val : map.get(key)) {
            if (val == edge[1]) {
              toBeAdded.add(List.of(key, edge[0]));
            }
          }
        }
        toBeAdded.forEach(l ->
            map.get(l.get(0)).add(l.get(1))
        );
      }
      for (int key : map.keySet()) {
        for (int val : map.get(key)) {
          List<Integer> temp = List.of(val, key);
          ret.add(temp);
        }
      }
      return ret;
    }

    private Boolean dfs(int numCourses, int[][] prerequisites, int start, int end, Set<Integer> visited) {
      if (start == end) {
        return true;
      }
      visited.add(start);
      List<int[]> startEdges = Arrays.stream(prerequisites).filter(edge -> edge[0] == start && !visited.contains(edge[1])).toList();
      if (visited.size() == numCourses) {
        return startEdges.stream().reduce(false, (b, edge) -> b | (edge[1] == end), Boolean::logicalOr);
      }
      for (int[] edge : startEdges) {
        if (dfs(numCourses, prerequisites, edge[1], end, visited)) {
          return true;
        }
      }
      return false;
    }
  }
}