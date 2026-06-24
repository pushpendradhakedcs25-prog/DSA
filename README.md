
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
class Solution {
    static final long M = 1000000007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;

        int s = 2 * m;
        long[][] t = new long[s][s];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) t[m + i][j] = 1;
            for (int i = j + 1; i < m; i++) t[i][m + j] = 1;
        }

        long[] v = new long[s];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a < b) v[b]++;
                else if (a > b) v[m + b]++;
            }
        }

        long[][] p = pow(t, n - 2);
        long[] res = mul(v, p);

        long ans = 0;
        for (long x : res) ans = (ans + x) % M;
        return (int) ans;
    }

    long[] mul(long[] a, long[][] b) {
        int n = a.length;
        long[] r = new long[n];
        for (int i = 0; i < n; i++)
            if (a[i] != 0)
                for (int j = 0; j < n; j++)
                    r[j] = (r[j] + a[i] * b[i][j]) % M;
        return r;
    }

    long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] r = new long[n][n];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++)
                if (a[i][k] != 0)
                    for (int j = 0; j < n; j++)
                        r[i][j] = (r[i][j] + a[i][k] * b[k][j]) % M;
        return r;
    }

    long[][] pow(long[][] a, long e) {
        int n = a.length;
        long[][] r = new long[n][n];
        for (int i = 0; i < n; i++) r[i][i] = 1;

        while (e > 0) {
            if ((e & 1) == 1) r = mul(r, a);
            a = mul(a, a);
            e >>= 1;
        }
        return r;
    }
}

