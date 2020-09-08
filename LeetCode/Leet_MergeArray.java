class Leet_MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;
        int i = 0, j = 0;
        String s ="";
        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                s = s+nums2[j]+";";
                j++;
            }else{
                s = s+nums1[i]+";";
                i++;
            }
        }
        while(j<n){
            s = s+nums2[j]+";";
            j++;
        }
        while(i < nums1.length-n){
            s = s+nums1[i]+";";
            i++;
        }
        s = s.substring(0, s.length()-1);
        System.out.println(s);
        int v=0;
        for(String x: s.split(";")){
            nums1[v] = Integer.parseInt(x);
            v++;
        }
    }
}