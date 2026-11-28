import java.util.*;
public class MergeNSortedLists {


    /*
    
    O (m.n²)
    */

    public static List<Integer> mergeNSortedLists(List<List<Integer>> lists) {
        
        List<Integer> res = new ArrayList<>();
        int n = lists.size();
        
        int m = 0;
        for (List<Integer> list : lists) {
            if (list.size() > m) {
                m = list.size();
            }
        }
        
        int[] pointers = new int[n];
        
        while (true) {
            
            int least = Integer.MAX_VALUE, listLeast = -1;
            
            for (int j = 0; j < n; j++) {
                
                if (pointers[j] < lists.get(j).size()) {
                    
                    if (lists.get(j).get(pointers[j]) < least) {
                        listLeast = j;
                        least = lists.get(j).get(pointers[j]);
                    }
                    
                } 
                
            }
            
            if (listLeast > -1) {
                res.add(lists.get(listLeast).get(pointers[listLeast]));
                pointers[listLeast]++;
            } else {
                break;
            }
            
        }
        
        
        return res;
    }
}


/*


[]0,1,4,7
1,3,4,5
0,2,3,4
2,6,7,9







*/
