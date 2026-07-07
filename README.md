class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        int p = 1;

        while (n > 0) {
            int d = n % 10;
            if (d != 0) {
                x += d * p;
                p *= 10;
                sum += d;
            }
            n /= 10;
        }

        return 1L * x * sum;
    }
} Solution {
  public int minScore(int n, int[][] roads) {
    int ans = Integer.MAX_VALUE;
    List<Pair<Integer, Integer>>[] graph = new List[n]; // graph[u] := [(v, distance)]
    Queue<Integer> q = new ArrayDeque<>(List.of(0));
    boolean[] seen = new boolean[n];
    seen[0] = true;
    Arrays.setAll(graph, i -> new ArrayList<>());

    for (final int[] r : roads) {
      final int u = r[0] - 1;
      final int v = r[1] - 1;
      final int distance = r[2];
      graph[u].add(new Pair<>(v, distance));
      graph[v].add(new Pair<>(u, distance));
    }

    while (!q.isEmpty()) {
      final int u = q.poll();
      for (Pair<Integer, Integer> pair : graph[u]) {
        final int v = pair.getKey();
        final int d = pair.getValue();
        ans = Math.min(ans, d);
        if (seen[v])
          continue;
        q.offer(v);
        seen[v] = true;
      }
    }

    return ans;
  }
}
class Solution {
  public int[] pathsWithMaxScore(List<String> board) {
    final int MOD = 1_000_000_007;
    final int[][] DIRS = {{0, 1}, {1, 0}, {1, 1}};
    final int n = board.size();
 
    int[][] dp = new int[n + 1][n + 1];
    Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));

    int[][] count = new int[n + 1][n + 1];

    dp[0][0] = 0;
    dp[n - 1][n - 1] = 0;
    count[n - 1][n - 1] = 1;

    for (int i = n - 1; i >= 0; --i)
      for (int j = n - 1; j >= 0; --j) {
        if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'X')
          continue;
        for (int[] dir : DIRS) {
          final int x = i + dir[0];
          final int y = j + dir[1];
          if (dp[i][j] < dp[x][y]) {
            dp[i][j] = dp[x][y];
            count[i][j] = count[x][y];
          } else if (dp[i][j] == dp[x][y]) {
            count[i][j] += count[x][y];
            count[i][j] %= MOD;
          }
        }
    
        if (dp[i][j] != -1 && board.get(i).charAt(j) != 'E') {
          dp[i][j] += board.get(i).charAt(j) - '0';
          dp[i][j] %= MOD;
        }
      }

    return new int[] {dp[0][0], count[0][0]};
  }
}
