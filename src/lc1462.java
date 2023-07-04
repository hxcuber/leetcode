import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1462 {
  class Solution{
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequesites, int[][] queries) {
      // basically dfs
      // find if there a path in prerequisites that matches the start and finish of queries
      return Arrays.stream(queries).map(query -> dfs(numCourses, prerequesites, query[0], query[1], new HashSet<>())).toList();
    }

    private Boolean dfs(int numCourses, int[][] prerequesites, int start, int end, Set<Integer> visited) {
      if (start == end) {
        return true;
      }
      visited.add(start);
      List<int[]> startEdges = Arrays.stream(prerequesites).filter(edge -> edge[0] == start && !visited.contains(edge[1])).toList();
      if (visited.size() == numCourses) {
        return startEdges.stream().reduce(false, (b, edge) -> b | (edge[1] == end), Boolean::logicalOr);
      }
      return startEdges.stream().map(edge -> dfs(numCourses, prerequesites, edge[1], end, visited)).reduce(false, Boolean::logicalOr);
    }
  }
}