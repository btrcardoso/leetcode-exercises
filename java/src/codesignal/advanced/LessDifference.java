package codesignal.advanced;
// https://codesignal.com/learn/course/351/unit/1/practice/2

/*

Deep within the kingdom of Million Numbers, a challenge was set before the esteemed Java developer. This kingdom was a land of diversity, filled with n elements, each an integer between 
−
10
6
−10 
6
  and 
10
6
10 
6
 . The count of these elements was no small number either - ranging anywhere from 
1
1 to a whopping 
10
6
10 
6
 .

The Java developer was handed a scroll that represented these elements as a list of integers. The Java developer's task? To delve deep into this pool of numbers and find the smallest absolute difference between any pair of elements.

In the kingdom of Million Numbers, the absolute difference was measured as |a - b|, where a and b signified any two elements from the list.

The Java developer was asked to weave a magical function named public int solution(List<Integer> nums). This Java function would take in the list of integers 'nums', representative of all elements in the kingdom; it would parse through the sea of numbers and elegantly return the smallest absolute difference among all possible pairs.

Although the kingdom was grand in scale, efficiency was revered. The Java developer's magic had to be potent and swift - an optimized spell capable of working at a time complexity of 
O
(
n
log
⁡
n
)
O(nlogn) or better, to ensure the quickest resolution to the kingdom's interesting challenge.

Notes:

If n = 1, the minimum absolute difference is 0, since there is only one number, leaving no other number to pair it with.
It is guaranteed that the list nums contains no duplicate numbers.

*/

import java.util.Collections;
import java.util.List;

public class LessDifference{
    public int solution(List<Integer> nums) {
        
        int n = nums.size();

        if (n < 2) return 0;
        
        Collections.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            long diff = (long) (nums.get(i) - nums.get(i+1));
            min = Math.min(min, (int) Math.abs(diff));
        }
        
        return min;
    }
}