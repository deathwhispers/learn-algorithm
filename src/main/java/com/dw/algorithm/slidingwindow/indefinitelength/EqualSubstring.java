package com.dw.algorithm.slidingwindow.indefinitelength;

/**
 * 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 */
public class EqualSubstring {

    public static void main(String[] args) {
        EqualSubstring equalSubstring = new EqualSubstring();
        int i = equalSubstring.equalSubstring("abcd", "bcdf", 3);
        System.out.println(i);
    }

      public int equalSubstring(String s, String t, int maxCost) {
          int ans = 0;
          int n = s.length();
          int left = 0;
          int cost = 0;
          for (int right = 0; right < n; right++) {
              // 右侧元素进入窗口
              cost += Math.abs(s.charAt(right) - t.charAt(right));
              while (cost > maxCost) {
                  cost -= Math.abs(s.charAt(left) - t.charAt(left));
                  left++;
              }
              ans = Math.max(ans, right - left + 1);

          }
          return ans;
    }
}
