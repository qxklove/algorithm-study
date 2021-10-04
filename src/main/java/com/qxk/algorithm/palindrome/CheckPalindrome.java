package com.qxk.algorithm.palindrome;

/**
 * 验证回文串
 * LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author qxk
 * @date 2021/10/04
 */
public class CheckPalindrome {

    //双指针法
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            // 从头和尾开始向中间遍历
            // 字符不是字母和数字的情况继续移动指针
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                // 判断二者是否相等
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
