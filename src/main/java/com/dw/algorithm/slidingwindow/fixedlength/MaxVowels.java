package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 定长子串中元音的最大数目
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/20 10:39
 * <a href = "https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/">定长子串中元音的最大数目</a>
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        int result = 0;
        int vowel = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                vowel++;
            }
            if (i < k - 1) {
                continue;
            }
            result = Math.max(result, vowel);

            char out = arr[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return result;
    }
}
