public class CiscoJars {
    public static void main(String args[]) {
        // 5 78 90 80 10 -- 158
        int jars[] = new int[] { 5, 30, 99, 60, 5, 10 }; // 114 -- 5, 99, 10

        int arr[] = new int[]{5, 5, 10, 100, 10, 5}; 
        System.out.println(FindMaxSum(jars, jars.length));
    }

    static int FindMaxSum(int arr[], int n) 
    { 
        int incl = arr[0]; 
        int excl = 0; 
        int excl_new; 
        int i; 
  
        for (i = 1; i < n; i++) 
        { 
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl; 
  
            /* current max including i */
            incl = excl + arr[i]; 
            excl = excl_new; 
        } 
  
        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl); 
    } 
}