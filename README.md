List<Integer> ans = new ArrayList<>();
class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;
    private int[] nums;
    private int n;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        memo = new int[n][max + 1][max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                java.util.Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 > 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != -1) {
            return memo[idx][g1][g2];
        }

        long ans = 0;

        // Skip current element
        ans += dfs(idx + 1, g1, g2);

        // Put into first subsequence
        ans += dfs(idx + 1, gcd(g1, nums[idx]), g2);

        // Put into second subsequence
        ans += dfs(idx + 1, g1, gcd(g2, nums[idx]));

        memo[idx][g1][g2] = (int) (ans % MOD);
        return memo[idx][g1][g2];
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
} Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;
    private int[] nums;
    private int n;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        memo = new int[n][max + 1][max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                java.util.Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 > 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != -1) {
            return memo[idx][g1][g2];
        }

        long ans = 0;

        // Skip current element
        ans += dfs(idx + 1, g1, g2);

        // Put into first subsequence
        ans += dfs(idx + 1, gcd(g1, nums[idx]), g2);

        // Put into second subsequence
        ans += dfs(idx + 1, g1, gcd(g2, nums[idx]));

        memo[idx][g1][g2] = (int) (ans % MOD);
        return memo[idx][g1][g2];
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}    Queue<Integer> q = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

    while (!q.isEmpty()) {
      final int num = q.poll();
      if (num > high)
        return ans;
      if (low <= num && num <= high)
        ans.add(num);
      final int lastDigit = num % 10;
      if (lastDigit < 9)
        q.offer(num * 10 + lastDigit + 1);
    }

    return ans;
  }
} Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> ans = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

    while (!q.isEmpty()) {
      final int num = q.poll();
      if (num > high)
        return ans;
      if (low <= num && num <= high)
        ans.add(num);
      final int lastDigit = num % 10;
      if (lastDigit < 9)
        q.offer(num * 10 + lastDigit + 1);
    }

    return ans;
  }
} {
  public int[] arrayRankTransform(int[] arr) {
    int[] sortedArr = arr.clone();
    Map<Integer, Integer> rank = new HashMap<>();

    Arrays.sort(sortedArr);
    
class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    
    for (final int a : sortedArr)
      rank.putIfAbsent(a, rank.size() + 1);

    for (int i = 0; i < arr.length; ++i)
      arr[i] = rank.get(arr[i]);

    return arr;
  }
} UnionFind {
  public UnionFind(int n) {
    id = new int[n];
    rank = new int[n];
    nodeCount = new int[n];
    edgeCount = new int[n];
    for (int i = 0; i < n; ++i) {
      id[i] = i;
      nodeCount[i] = 1;
    }
  }
  public void unionByRank(int u, int v) {
    final int i = find(u);
    final int j = find(v);
    ++edgeCount[i];
    if (i == j)
      return;
    if (rank[i] < rank[j]) {
      id[i] = j;
      edgeCount[j] += edgeCount[i];
      nodeCount[j] += nodeCount[i];
    } else if (rank[i] > rank[j]) {
      id[j] = i;
      edgeCount[i] += edgeCount[j];
      nodeCount[i] += nodeCount[j];
    } else {
      id[i] = j;
      edgeCount[j] += edgeCount[i];
      nodeCount[j] += nodeCount[i];
      ++rank[j];
    }
  }

  public int find(int u) {
    return id[u] == u ? u : (id[u] = find(id[u]));
  }

  public boolean isComplete(int u) {
    return nodeCount[u] * (nodeCount[u] - 1) / 2 == edgeCount[u];
  }

  private int[] id;
  private int[] rank;
  private int[] nodeCount;
  private int[] edgeCount;
}

class Solution {
  public int countCompleteComponents(int n, int[][] edges) {
    int ans = 0;
    UnionFind uf = new UnionFind(n);
    Set<Integer> parents = new HashSet<>();

    for (int[] edge : edges) {
      final int u = edge[0];
      final int v = edge[1];
      uf.unionByRank(u, v);
    }

    for (int i = 0; i < n; ++i) {
      final int parent = uf.find(i);
      if (parents.add(parent) && uf.isComplete(parent))
        ++ans;
    }

    return ans;
  }
}
 Solution {
  public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[] ans = new int[queries.length];
    int[] indexMap = new int[n];
    int[] sortedNums = new int[n];
    Pair<Integer, Integer>[] sortedNumAndIndexes = new Pair[n];

    for (int i = 0; i < n; ++i)
      sortedNumAndIndexes[i] = new Pair<>(nums[i], i);

    Arrays.sort(sortedNumAndIndexes, Comparator.comparingInt(Pair::getKey));

    for (int i = 0; i < n; ++i) {
      final int num = sortedNumAndIndexes[i].getKey();
      final int sortedIndex = sortedNumAndIndexes[i].getValue();
      sortedNums[i] = num;
      indexMap[sortedIndex] = i;
    }

    final int maxLevel = Integer.SIZE - Integer.numberOfLeadingZeros(n) + 1;
    int[][] jump = new int[n][maxLevel];

    int right = 0;
    for (int i = 0; i < n; ++i) {
      while (right + 1 < n && sortedNums[right + 1] - sortedNums[i] <= maxDiff)
        ++right;
      jump[i][0] = right;
    }

    for (int level = 1; level < maxLevel; ++level)
      for (int i = 0; i < n; ++i) {
        final int prevJump = jump[i][level - 1];
        jump[i][level] = jump[prevJump][level - 1];
      }

    for (int i = 0; i < queries.length; ++i) {
      final int u = queries[i][0];
      final int v = queries[i][1];
      final int uIndex = indexMap[u];
      final int vIndex = indexMap[v];
      final int start = Math.min(uIndex, vIndex);
      final int end = Math.max(uIndex, vIndex);
      final int res = minJumps(jump, start, end, maxLevel - 1);
      ans[i] = res == Integer.MAX_VALUE ? -1 : res;
    }

    return ans;
  }

  private int minJumps(int[][] jump, int start, int end, int level) {
    if (start == end)
      return 0;
    if (jump[start][0] >= end)
      return 1;
    if (jump[start][level] < end)
      return Integer.MAX_VALUE;
    int j = level;
    for (; j >= 0; --j)
      if (jump[start][j] < end)
        break;
    return (1 << j) + minJumps(jump, jump[start][j], end, j);
  }
} Solution {
  public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    int[] ans = new int[queries.length];
    int[] indexMap = new int[n];
    int[] sortedNums = new int[n];
    Pair<Integer, Integer>[] sortedNumAndIndexes = new Pair[n];

    for (int i = 0; i < n; ++i)
      sortedNumAndIndexes[i] = new Pair<>(nums[i], i);

    Arrays.sort(sortedNumAndIndexes, Comparator.comparingInt(Pair::getKey));

    for (int i = 0; i < n; ++i) {
      final int num = sortedNumAndIndexes[i].getKey();
      final int sortedIndex = sortedNumAndIndexes[i].getValue();
      sortedNums[i] = num;
      indexMap[sortedIndex] = i;
    }

    final int maxLevel = Integer.SIZE - Integer.numberOfLeadingZeros(n) + 1;
    int[][] jump = new int[n][maxLevel];

    int right = 0;
    for (int i = 0; i < n; ++i) {
      while (right + 1 < n && sortedNums[right + 1] - sortedNums[i] <= maxDiff)
        ++right;
      jump[i][0] = right;
    }

    for (int level = 1; level < maxLevel; ++level)
      for (int i = 0; i < n; ++i) {
        final int prevJump = jump[i][level - 1];
        jump[i][level] = jump[prevJump][level - 1];
      }

    for (int i = 0; i < queries.length; ++i) {
      final int u = queries[i][0];
      final int v = queries[i][1];
      final int uIndex = indexMap[u];
      final int vIndex = indexMap[v];
      final int start = Math.min(uIndex, vIndex);
      final int end = Math.max(uIndex, vIndex);
      final int res = minJumps(jump, start, end, maxLevel - 1);
      ans[i] = res == Integer.MAX_VALUE ? -1 : res;
    }

    return ans;
  }

  private int minJumps(int[][] jump, int start, int end, int level) {
    if (start == end)
      return 0;
    if (jump[start][0] >= end)
      return 1;
    if (jump[start][level] < end)
      return Integer.MAX_VALUE;
    int j = level;
    for (; j >= 0; --j)
      if (jump[start][j] < end)
        break;
    return (1 << j) + minJumps(jump, jump[start][j], end, j);
  }
} Solution {
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
