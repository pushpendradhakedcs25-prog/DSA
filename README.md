class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int safe = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (vis[x][y]) continue;
            vis[x][y] = true;

            if (x == n - 1 && y == n - 1) return safe;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (vis[nx][ny]) continue;

                pq.offer(new int[]{Math.min(safe, dist[nx][ny]), nx, ny});
            }
        }

        return 0;
    }
}
DSA
/README.md
pushpendradhakedcs25-prog
pushpendradhakedcs25-prog
Update README.md
bf316fb
 · 
now

Preview

Code

Blame
7 lines (2 loc) · 279 Bytes
🎓 B.Tech Computer Science @ GLA University, Mathura🚀 Java Developer | 🎓 CSE Student @ GLA University | 💻 Aspiring Software !

🎓 B.Tech Computer Science @ GLA University, Mathura🚀 Java Developer | 🎓 CSE Student @ GLA University | 💻 Aspiring Software !
class  ]  
class Solution {
  public int maximumLength(int[] nums) {
    final int maxNum = Arrays.stream(nums).max().getAsInt();
    Map<Integer, Integer> count = new HashMap<>();

    for (final int num : nums)
      count.merge(num, 1, Integer::sum);

    int ans = count.containsKey(1) ? count.get(1) - (count.get(1) % 2 == 0 ? 1 : 0) : 1;

    for (final int num : nums) {
      if (num == 1)
        continue;
      int length = 0;
      long x = num;
      while (x <= maxNum && count.containsKey((int) x) && count.get((int) x) >= 2) {
        length += 2;
        x *= x;
      }
      
      ans = Math.max(ans, length + (count.containsKey((int) x) ? 1 : -1));
    }

    return ans;
  }
}class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += n - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}
