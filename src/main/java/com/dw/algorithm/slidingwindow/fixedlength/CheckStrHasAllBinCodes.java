package com.dw.algorithm.slidingwindow.fixedlength;

import java.util.HashSet;

/**
 * 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/14 14:58
 * <a href ="https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/>检查一个字符串是否包含所有长度为 K 的二进制子串</a>
 */
public class CheckStrHasAllBinCodes {
    public static void main(String[] args) {
        CheckStrHasAllBinCodes test = new CheckStrHasAllBinCodes();
        boolean b = test.hasAllCodes("00110", 2);
        System.out.println(b);
    }

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            hashSet.add(s.substring(i, i + k));
        }
        return hashSet.size() >= Math.pow(2, k);
    }

    public boolean hasAllCodes2(String s, int k) {
        StringBuilder builder = new StringBuilder();
        char[] cs = s.toCharArray();
        int n = cs.length;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            builder.append(cs[i]);
            if (i < k - 1) {
                continue;
            }
            hashSet.add(builder.toString());
            builder.deleteCharAt(0);
        }
        return hashSet.size() >= Math.pow(2, k);
    }
}
