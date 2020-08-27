import java.util.Arrays;
import java.util.Scanner;

//Ouput maximum difference of two number where large number appears AFTER the smaller number

public class Cisco_MaxDiff {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i=0; i<t; i++){
		    int n = Integer.parseInt(sc.nextLine());
		    int arr[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    System.out.println(maxDiff(arr));
		}
	}
	static int maxDiff(int arr[]){
	    int max=Integer.MIN_VALUE;
	    int min = arr[0];
	    for(int i=1;i<arr.length; i++){
	        max = Math.max(max, arr[i]-min);
	        min = Math.min(min, arr[i]);
	    }
	    return max <=0 ? -1 : max;
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
//     public static void main(String args[]){
//         int arr[] = {2,3,10,6,4,8,1};   //O/p - 8
//         System.out.println(maxDiff(arr));
//     }
//     static int indexOf(int num, int arr[]){
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] == num){
//                 return i;
//             }
//         }
//         return Integer.MAX_VALUE;
//     }
//     static int maxDiff(int arr[]){
//         // arr is 7,9,5,6,3,2
//         int temp[] = arr.clone();
//         Arrays.sort(temp);  // 2,3,5,6,7,9
//         int i=0, j=0, max = Integer.MIN_VALUE;
//         while(j < temp.length){
            
//             while(i<temp.length){
//                 if(indexOf(temp[i], arr) < indexOf(temp[temp.length-j-1], arr)){
//                     max = Math.max(temp[temp.length-j-1]-temp[i], max);
//                 }
//                 i++;
//             }
//             j++;
//         }
//         return 0;
//     }
// }