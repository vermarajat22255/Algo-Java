class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[128];
        int count =0,sum=0;
        int i =0,j=0;
         while(j< s.length()){
            // System.out.println(s.charAt(i)-0);
            while(i<s.length() && arr[s.charAt(i)-0] == 0){
                arr[s.charAt(i)-0] =1;
                count++;
                i++;
            }
            if(count>sum) sum = count;
            System.out.println("->"+sum);
            Arrays.fill(arr,0);
            count =0;
            i=j;
            j++;
        }
        return sum>count?sum:count;
    }
}
