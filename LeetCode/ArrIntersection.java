import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArrIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hm.containsKey(nums1[i])) {
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            } else {
                hm.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hm.containsKey(nums2[i]) && hm.get(nums2[i]) > 0) {
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
                al.add(nums2[i]);
            }
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
    // Without using HashMap
    public int[] intersect2(int[] nums1, int[] nums2) {
            if(nums1.length == 0 || nums2.length == 0) return new int[]{};
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int ptr1 = 0, ptr2= 0;
            String s = "";
            while(ptr1< nums1.length && ptr2 < nums2.length){
                if(nums1[ptr1] == nums2[ptr2]){
                    s = s+nums1[ptr1]+";";
                    ptr1++;
                    ptr2++;
                }else if(nums1[ptr1] > nums2[ptr2]){
                    ptr2++;
                }else ptr1++;
            }
            return s.length() > 0 ? Arrays.stream(s.split(";")).mapToInt(i -> Integer.parseInt(i)).toArray() : new int[]{};
        }
}

