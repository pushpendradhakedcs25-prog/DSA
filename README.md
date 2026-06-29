
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


