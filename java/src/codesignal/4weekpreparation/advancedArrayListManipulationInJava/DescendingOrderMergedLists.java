import java.util.*;


/*
https://codesignal.com/learn/course/479/unit/4/practice/2
You are given two sorted lists in ascending order, each containing n integers. Your task is to merge these two lists into a new list such that:

The resulting list is sorted in descending order.
If there are duplicate elements in the two lists, they should be merged so that each duplicate appears only once in the final list.
For instance, if you are given two lists, [1, 2, 3, 4, 5] and [3, 4, 5, 6, 7], your function should return [7, 6, 5, 4, 3, 2, 1] as the merged list.

*/

public class DescendingOrderMergedLists {

    public static List<Integer> mergeSortedListsDescendingUnique(List<Integer> list1, List<Integer> list2) {
        
        int i = list1.size() - 1, j = list2.size() - 1;
        List<Integer> res = new ArrayList<>();
        
        while (i >= 0 && j >= 0) {
            
            Integer last = res.getLast();
            Integer e1 = list1.get(i);
            Integer e2 = list2.get(j);
            
            if (e1 >= e2){
                if (e1 != last) {
                    res.add(e1);
                }
                i--;
            } else {
                if (e2 != last) {
                    res.add(e2);
                }
                j--;
            }
            
        }
        
        while (i >= 0) {
            Integer last = res.getLast();
            Integer e1 = list1.get(i);
            if (e1 != last) {
                res.add(e1);
            }
            i--;
        }
        
        while (j >= 0) {
            Integer last = res.getLast();
            Integer e2 = list2.get(j);
            if (e2 != last) {
                res.add(e2);
            }
            j--;
        }
    
    
        return res;
        
    }
}