public class Code1328 {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        // 特殊返回
        if (len <= 1)
            return "";
        // 遍历
        char[] chars = palindrome.toCharArray();
        int flag = 0;
        for (int i = 0; i < len / 2; i++) {
            if (palindrome.charAt(i) != 'a'){
                chars[i] = 'a';
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            chars[len - 1] = 'b';
        }
        return new String(chars);
    }
}
