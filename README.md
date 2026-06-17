🎓 B.Tech Computer Science @ GLA University, Mathura🚀 Java Developer | 🎓 CSE Student @ GLA University | 💻 Aspiring Software !


class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Compute final length
        for (char c : s.toCharArray()) {
            if (c == '*') {
                len = Math.max(0, len - 1);
            } else if (c == '#') {
                len *= 2;
            } else if (c != '%') {
                len++;
            }
        }

        if (k >= len) return '.';

        // Reverse simulation
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                len++;
            } else if (c == '#') {
                len /= 2;
                if (k >= len) k -= len;
            } else if (c == '%') {
                k = len - 1 - k;
            } else {
                len--;
                if (k == len) return c;
            }
        }

        return '.';
    }
}
