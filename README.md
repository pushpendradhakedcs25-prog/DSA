class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] group = new int[n];
        int groupId = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                groupId++;
            }
            group[i] = groupId;
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (group[u] == group[v]);
        }

        return ans;
    }
} Solution {
class Solution {
    static final int MOD = 1000000007;

    public int[] concatNonZeroAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] next = new int[n + 1];
        next[n] = -1;
        for (int i = n - 1; i >= 0; i--)
            next[i] = s.charAt(i) != '0' ? i : next[i + 1];

        int[] id = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) != '0') id[i] = m++;

        int[] pos = new int[m], sum = new int[m + 1];
        long[] num = new long[m + 1], p10 = new long[m + 1];
        p10[0] = 1;

        for (int i = 0, k = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                pos[k] = i;
                int d = s.charAt(i) - '0';
                num[k + 1] = (num[k] * 10 + d) % MOD;
                sum[k + 1] = sum[k] + d;
                k++;
            }
        }

        for (int i = 1; i <= m; i++)
            p10[i] = p10[i - 1] * 10 % MOD;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int f = l < n ? next[l] : -1;

            if (f == -1 || f > r) {
                ans[i] = 0;
                continue;
            }

            int L = id[f], lo = L, hi = m - 1, R = L;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (pos[mid] <= r) {
                    R = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            int len = R - L + 1;
            long val = (num[R + 1] - num[L] * p10[len] % MOD + MOD) % MOD;
            ans[i] = (int) (val * (sum[R + 1] - sum[L]) % MOD);
        }

        return ans;
    }
}    public long sumAndMultiply(int n) {
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
