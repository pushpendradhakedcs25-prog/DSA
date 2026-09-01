import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        List<int[]> litter = new ArrayList<>();
        int sr = 0, sc = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litter.add(new int[]{r, c});
                }
            }
        }

        int k = litter.size();

        // If there is no litter, we're already done.
        if (k == 0) return 0;

        // State: row, col, energy, mask of cleaned litter
        // Use BFS because every move costs 1.
        int totalMasks = 1 << k;

        // visited[r][c][energy][mask]
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][totalMasks];

        Queue<int[]> q = new ArrayDeque<>();

        int startMask = 0;
        q.offer(new int[]{sr, sc, energy, startMask});
        visited[sr][sc][energy][startMask] = true;

        int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == totalMasks - 1) {
                    return moves;
                }

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    // Every movement consumes 1 energy.
                    if (e == 0)
                        continue;

                    int ne = e - 1;
                    int nmask = mask;

                    // Check if this cell contains litter.
                    for (int i = 0; i < k; i++) {
                        if (litter.get(i)[0] == nr &&
                            litter.get(i)[1] == nc) {
                            nmask |= (1 << i);
                            break;
                        }
                    }

                    // 'R' restores energy to the original value.
                    if (classroom[nr].charAt(nc) == 'R') {
                        ne = energy;
                    }

                    if (!visited[nr][nc][ne][nmask]) {
                        visited[nr][nc][ne][nmask] = true;
                        q.offer(new int[]{nr, nc, ne, nmask});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}