package com.dw.algorithm.classicinterview;

/**
 * 有效的字母异位词
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/17 16:22
 * @see <a href="https://leetcode.cn/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150">有效的字母异位词</a>
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
