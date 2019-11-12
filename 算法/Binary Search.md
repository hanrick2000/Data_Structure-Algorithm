# Binary Search

**LeetCode 744 Find Smallest Letter Greater Than Target**

一组排序的characters 数组，和target，找到比target大的最小元素。target大于等于所有值，返回第一个元素

```java
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"
Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"
```

直接遍历

```java
public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (target < c){
                return c;
            }
        }

        return letters[0];

    }
```

二分查找

```java
public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        if (target >= letters[end]){
            return letters[0];
        }

        while (start < end){
            int mid = (end - start)/2;

            if (target >= letters[mid]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        return letters[end];

    }
```

**非递减排序的数组旋转，输出最小元素**

[newcoder]([https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking))

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

两种方法：

1. 直接查找最小元素
2. 二分法变种

```java
public int minNumberInRotateArray_1(int [] array) {
        if (array.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i],min);
        }

        return min;
    }
```

```java
public int minNumberInRotateArray_2(int [] array){
        int left = 0;
        int right = array.length-1;

        while (left < right){
            int mid = left + (right-left)/2;
            if (array[mid] > array[right]){
                left = mid + 1;
            }else if (array[mid] == array[right]){
                right--;
            }else {
                right = mid;
            }
        }

        return array[left];
    }
```







