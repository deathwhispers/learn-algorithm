package com.dw.algorithm.classicinterview;

/**
 * 验证回文串
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/24 16:57
 * @see <a href="https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150">验证回文串</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
