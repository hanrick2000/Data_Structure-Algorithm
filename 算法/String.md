# String

LeetCode 3 Longest Substring Without Repeating Characters

```java
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

用hashset和快慢指针，hashset放不重复子串。对j位置字符做包含比较，如果不包含，加入hashset。如果包含，把从i位置开始的字符删除，直到不包含j位置的字符。

```java
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
}
```

LeetCode 5 Longest Palindromic Substring

最长回文子序列

```java
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Input: "cbbd"
Output: "bb"
```

思路都是使用指针，从两端相等点向中心方向靠近，或者从中心位置向两端远离，判断每移动一格，记录相等的String和length。

```java
private int lo, maxLen;
public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}
```

```java
	public String longestPalindrome(String s) {
       int len = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >=i ; j--) {
                if (s.charAt(i) == s.charAt(j)){
                    StringBuilder subs = new StringBuilder(s.substring(i,j+1));
                    if (subs.toString().equals(subs.reverse().toString())){
                        if (len < subs.length()){
                            res =subs.toString();
                            len = subs.length();
                        }
                         break;
                    }
                }
            }
        }

        return res; 
    }
```

**LeetCode 415 Add Strings**

两个代表正数的字符串，求sum

```java
public String addStrings(String num1, String num2) {
      StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i)-'0';
            int y = j < 0 ? 0 : num2.charAt(j)-'0';

            sb.append((x + y + carry) % 10);
            carry = (x + y+ carry) / 10;
        }
        
        if (carry > 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
```

**LeetCode 165 Compare Version Numbers**

两个版本version1，version2，如果version1>version2,返回1；version1>version2,返回-1；其他返回0

```java
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
```

按照`\\.` 切分，每一位比较，长度短的，默认补0；

```java
public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.max(s1.length,s2.length);

        for (int i = 0; i < len; i++) {
            Integer v1 = i<s1.length?Integer.parseInt(s1[i]):0;
            Integer v2 = i<s2.length?Integer.parseInt(s2[i]):0;

            int compare = v1.compareTo(v2);
            if (compare != 0){
                return compare;
            }
        }

        return 0;
    }
```

## 文章和段落

给一段英文，和禁止词数组。求：除了禁止词外，出现频率最高的词，不区分大小写。

```java
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
```

首先需要把段落按照词切分，用正则表达式：

```java
String[] word = paragraph.toLowerCase().split("[ !?',;.]+");
```

hashmap记录 word - count，去掉禁止词。遍历找到最大频率的词

```java
public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
```

**LeetCode 151 Reverse Words in a String**

输入字符串，按照每个单词翻转，多个空格要去掉

```java
Input: "the sky is blue"
Output: "blue is sky the"
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

使用String.trim()方法去掉首尾的空格，split按照空格切分，"\s+"表示一个或多个空格

```java
	public String reverseWords(String s) {
        String[] res = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = res.length-1; i >= 0; i--) {
            sb.append(res[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
```

**LeetCode 58 Length of Last Word**

给定一个由字母和空格组成的字符串，找出最后一个单词的长度。如果最后一个单词不存在，返回0；

```java
Example:
Input: "Hello World"
Output: 5
```

用StringBuilder把字符串翻转，然后从第一个开始遍历找到第一个出现空格的位置可能出现的情况如下

"A B";"A ";" A"; "   ";需要先把头尾的空格去掉

```java
public int lengthOfLastWord(String s) {
        StringBuilder sb  = new StringBuilder(s);
        sb.reverse();

       String res = sb.toString().trim();
        
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == ' '){
                return i;
            }
        }

        return res.length();
    }
```

**LeetCode 67 Add Binary**

给定两个二进制字符串，返回二进制和

```java
Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
```

从字符串的最后一个开始加，carry表示进位，StringBuilder保存和

```java
public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0){
                sum += a.charAt(i--)-'0';
            }
            if (j >= 0){
                sum += b.charAt(j--)-'0';
            }

            sb.append(sum%2);
            carry = sum/2;
        }

        if (carry > 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
```

## 字符串替换拼接

**leetcode.929 Unique Email Addresses**

每个email由 字符串1 + @ + 字符串，如 `alice@leetcode.com`。现在规定，字符串1出现 ' . ' 则忽略。出现 ' + '，后面的字符串舍去。如：`m.y+name@email.com` 最终是 `my@email.com` 。现在给定字符串数组，求有多少中不同类型

```
Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
```

使用字符串的方法 replace 和 split 重新将email字符串拼接，然后放入HashSet，最终计算size。

```java
	public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();

        for (String e: emails) {
            String[] str = e.split("@");
            String[] local = str[0].split("\\+");
            hashSet.add(local[0].replace(".", "") + "@" + str[1]);
        }

        return hashSet.size();
    }
```

**字符串循环移位包含**

[编程之美 3.1](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Leetcode%20%E9%A2%98%E8%A7%A3.md#)

```java
s1 = AABCD, s2 = CDAA
Return : true
```

给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。

s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。

**字符串循环移位**

[编程之美 2.17](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Leetcode%20%E9%A2%98%E8%A7%A3.md#)

```java
s = "abcd123" k = 3
Return "123abcd"
```

将字符串向右循环移动 k 位。

将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。

**字符串中单词的翻转**

[程序员代码面试指南](https://github.com/CyC2018/CS-Notes/blob/master/docs/notes/Leetcode%20%E9%A2%98%E8%A7%A3.md#)

```java
s = "I am a student"
Return "student a am I"
```

将每个单词翻转，然后将整个字符串翻转。

**两个字符串包含的字符是否完全相同**

[242. Valid Anagram (Easy)](https://leetcode.com/problems/valid-anagram/description/)

```java
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
```

可以用 HashMap 来映射字符与出现次数，然后比较两个字符串出现的字符数量是否相同。

由于本题的字符串只包含 26 个小写字符，因此可以使用长度为 26 的整型数组对字符串出现的字符进行统计，不再使用 HashMap。

```java
public boolean isAnagram(String s, String t) {
    int[] cnts = new int[26];
    for (char c : s.toCharArray()) {
        cnts[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
        cnts[c - 'a']--;
    }
    for (int cnt : cnts) {
        if (cnt != 0) {
            return false;
        }
    }
    return true;
}
```

**计算一组字符集合可以组成的回文字符串的最大长度**

[409. Longest Palindrome (Easy)](https://leetcode.com/problems/longest-palindrome/description/)

```java
Input : "abccccdd"
Output : 7
Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
```

使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。

因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。

```java
public int longestPalindrome(String s) {
    int[] cnts = new int[256];
    for (char c : s.toCharArray()) {
        cnts[c]++;
    }
    int palindrome = 0;
    for (int cnt : cnts) {
        palindrome += (cnt / 2) * 2;
    }
    if (palindrome < s.length()) {
        palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
    }
    return palindrome;
}
```

**字符串同构**

[205. Isomorphic Strings (Easy)](https://leetcode.com/problems/isomorphic-strings/description/)

```java
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
```

记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。

```java
public boolean isIsomorphic(String s, String t) {
    int[] preIndexOfS = new int[256];
    int[] preIndexOfT = new int[256];
    for (int i = 0; i < s.length(); i++) {
        char sc = s.charAt(i), tc = t.charAt(i);
        if (preIndexOfS[sc] != preIndexOfT[tc]) {
            return false;
        }
        preIndexOfS[sc] = i + 1;
        preIndexOfT[tc] = i + 1;
    }
    return true;
}
```

**回文子字符串个数**

[647. Palindromic Substrings (Medium)](https://leetcode.com/problems/palindromic-substrings/description/)

```java
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
```

从字符串的某一位开始，尝试着去扩展子字符串。

```java
private int cnt = 0;

public int countSubstrings(String s) {
    for (int i = 0; i < s.length(); i++) {
        extendSubstrings(s, i, i);     // 奇数长度
        extendSubstrings(s, i, i + 1); // 偶数长度
    }
    return cnt;
}

private void extendSubstrings(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        start--;
        end++;
        cnt++;
    }
}
```

**判断一个整数是否是回文数**

[9. Palindrome Number (Easy)](https://leetcode.com/problems/palindrome-number/description/)

要求不能使用额外空间，也就不能将整数转换为字符串进行判断。

将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。

```java
public boolean isPalindrome(int x) {
    if (x == 0) {
        return true;
    }
    if (x < 0 || x % 10 == 0) {
        return false;
    }
    int right = 0;
    while (x > right) {
        right = right * 10 + x % 10;
        x /= 10;
    }
    return x == right || x == right / 10;
}
```

**统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数**

[696. Count Binary Substrings (Easy)](https://leetcode.com/problems/count-binary-substrings/description/)

```java
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
public int countBinarySubstrings(String s) {
    int preLen = 0, curLen = 1, count = 0;
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
            curLen++;
        } else {
            preLen = curLen;
            curLen = 1;
        }

        if (preLen >= curLen) {
            count++;
        }
    }
    return count;
}
```

**字符串替换空格**

[剑指offer]([https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking))

将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为`We%20Are%20Happy` 

1. 使用String.replace方法
2. 使用StringBuffer从后往前查找替换
3. 从前往后先找出有多少空格，定义字符串应该增加的长度。然后从后往前移动，将字符串中字母移动

方法二实现

```java
public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = str.length()-1; i >= 0 ; i--) {
            char c = str.charAt(i);
            if (c == ' '){
                sb.append("02%");
            }else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
```

方法三实现

```java
	public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }

        int oldIndex = str.length()-1;
        int newlen = str.length()+spaceNum*2;
        int newIndex = newlen - 1;
        str.setLength(newlen);
        for (; oldIndex>= 0; oldIndex--) {
            char temp = str.charAt(oldIndex);
            if (temp == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,temp);
            }
        }

        return str.toString();
    }
```



















