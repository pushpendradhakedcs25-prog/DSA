class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        boolean[] ans = new boolean[2048];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        for (int x = 0; x < 2048; x++) {
            if (!pair[x]) continue;
            for (int v : nums) {
                ans[x ^ v] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }
        return count;
    }
} Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        boolean[] ans = new boolean[2048];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        for (int x = 0; x < 2048; x++) {
            if (!pair[x]) continue;
            for (int v : nums) {
                ans[x ^ v] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }
        return count;
    }
} Group {
  public int start;
  public int length;
  public Group(int start, int length) {
    this.start = start;
    this.length = length;
  }
}

class SparseTable {
  public SparseTable(int[] nums) {
    n = nums.length;
    st = new int[bitLength(n) + 1][n + 1];
    System.arraycopy(nums, 0, st[0], 0, n);
    for (int i = 1; i <= st.length; ++i)
      for (int j = 0; j + (1 << i) <= n; ++j)
        st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
  }

  
  public int query(int l, int r) {
    final int i = bitLength(r - l + 1) - 1;
    return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
  }

  private final int n;
  private final int[][] st;

  private int bitLength(int n) {
    return Integer.SIZE - Integer.numberOfLeadingZeros(n);
  }
}

class Solution {
  public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
    final int n = s.length();
    final int ones = (int) s.chars().filter(c -> c == '1').count();
    final Pair<List<Group>, int[]> zeroGroupsInfo = getZeroGroups(s);
    final List<Group> zeroGroups = zeroGroupsInfo.getKey();
    final int[] zeroGroupIndex = zeroGroupsInfo.getValue();

    if (zeroGroups.isEmpty())
      return Collections.nCopies(queries.length, ones);

    final SparseTable st = new SparseTable(getZeroMergeLengths(zeroGroups));
    final List<Integer> ans = new ArrayList<>();

    for (int[] query : queries) {
      final int l = query[0];
      final int r = query[1];
      final int left = zeroGroupIndex[l] == -1 ? -1
                                               : (zeroGroups.get(zeroGroupIndex[l]).length -
                                                  (l - zeroGroups.get(zeroGroupIndex[l]).start));
      final int right =
          zeroGroupIndex[r] == -1 ? -1 : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);
      final Pair<Integer, Integer> adjacentIndices = mapToAdjacentGroupIndices(
          zeroGroupIndex[l] + 1, s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1);
      final int startAdjacentGroupIndex = adjacentIndices.getKey();
      final int endAdjacentGroupIndex = adjacentIndices.getValue();

      int activeSections = ones;
      if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r])
        activeSections = Math.max(activeSections, ones + left + right);
      else if (startAdjacentGroupIndex <= endAdjacentGroupIndex)
        activeSections = Math.max(activeSections,
                                  ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex));
      if (s.charAt(l) == '0' &&
          zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1))
        activeSections =
            Math.max(activeSections, ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
      if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1)
        activeSections =
            Math.max(activeSections, ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
      ans.add(activeSections);
    }

    return ans;
  }


  private Pair<List<Group>, int[]> getZeroGroups(String s) {
    final List<Group> zeroGroups = new ArrayList<>();
    final int[] zeroGroupIndex = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        if (i > 0 && s.charAt(i - 1) == '0')
          zeroGroups.get(zeroGroups.size() - 1).length++;
        else
          zeroGroups.add(new Group(i, 1));
      }
      zeroGroupIndex[i] = zeroGroups.size() - 1;
    }

    return new Pair<>(zeroGroups, zeroGroupIndex);
  }

  
  private int[] getZeroMergeLengths(List<Group> zeroGroups) {
    final int[] zeroMergeLengths = new int[zeroGroups.size() - 1];
    for (int i = 0; i < zeroGroups.size() - 1; ++i)
      zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
    return zeroMergeLengths;
  }


  private Pair<Integer, Integer> mapToAdjacentGroupIndices(int startGroupIndex, int endGroupIndex) {
    return new Pair<>(startGroupIndex, endGroupIndex - 1);
  }
} Solution {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    final int m = grid.length;
    final int n = grid[0].length;
    List<List<Integer>> ans = new ArrayList<>();
    int[][] arr = new int[m][n];

    k %= m * n;

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j) {
        final int index = (i * n + j + k) % (m * n);
        final int x = index / n;
        final int y = index % n;
        arr[x][y] = grid[i][j];
      }

    for (int[] row : arr)
      ans.add(Arrays.stream(row).boxed().collect(Collectors.toList()));

    return ans;
  }
}
class Solution {
  public String smallestSubsequence(String text) {
    StringBuilder sb = new StringBuilder();
    int[] count = new int[128];
    boolean[] used = new boolean[128];

    for (final char c : text.toCharArray())
      ++count[c];

    for (final char c : text.toCharArray()) {
      --count[c];
      if (used[c])
        continue;
      while (sb.length() > 0 && last(sb) > c && count[last(sb)] > 0) {
        used[last(sb)] = false;
        sb.setLength(sb.length() - 1);
      }
      used[c] = true;
      sb.append(c);
    }

    return sb.toString();
  }

  private char last(StringBuilder sb) {
    return sb.charAt(sb.length() - 1);
  }
} class Solution {
    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

    
        while (max % min != 0) {
            int temp = max % min;
            max = min;
            min = temp;
        }

        return min;
    }
}
class Solution {
  public int[] gcdValues(int[] nums, long[] queries) {
    int maxNum = Arrays.stream(nums).max().getAsInt();
    int[] ans = new int[queries.length];
   
    int[] countDivisor = new int[maxNum + 1];
 
    long[] countGcdPair = new long[maxNum + 1];
    
    long[] prefixCountGcdPair = new long[maxNum + 1];

    for (final int num : nums)
      for (int i = 1; i * i <= num; ++i)
        if (num % i == 0) {
          ++countDivisor[i];
          if (i != num / i)
            ++countDivisor[num / i];
        }

    for (int gcd = maxNum; gcd >= 1; --gcd) {
      
      countGcdPair[gcd] = (long) countDivisor[gcd] * (countDivisor[gcd] - 1) / 2;
      for (int largerGcd = 2 * gcd; largerGcd <= maxNum; largerGcd += gcd)
        countGcdPair[gcd] -= countGcdPair[largerGcd];
    }

    for (int gcd = 1; gcd <= maxNum; ++gcd)
      prefixCountGcdPair[gcd] = prefixCountGcdPair[gcd - 1] + countGcdPair[gcd];

    for (int i = 0; i < queries.length; ++i)
      ans[i] = getNthGcdPair(queries[i], prefixCountGcdPair);

    return ans;
  }
  private int getNthGcdPair(long query, long[] prefixCountGcdPair) {
    int l = 1;
    int r = prefixCountGcdPair.length - 1;
    while (l < r) {
      int m = (l + r) / 2;
      if (prefixCountGcdPair[m] < query + 1)
        l = m + 1;
      else
        r = m;
    }
    return l;
  }
} Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            mx = Math.max(mx, x);
            prefixGcd[i] = gcd(x, mx);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
} Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
} ans = new ArrayList<>();
class Solution {
    
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
