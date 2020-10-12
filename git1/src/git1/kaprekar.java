package git1;

import java.util.Scanner;

public class kaprekar {

	public static void main(String[] args) {
		   Scanner ob=new Scanner(System.in);
	    int t = ob.nextInt();
int j;
	    while(t!=0){
	         //  while(true) {
	            int n=ob.nextInt();
	           
	            int N=n*n;
	            int tn=n;int c=0;	
	            while(tn!=0)
	            { 
	                tn=tn/10;c++;
	            }
	            int q=(int)(N/Math.pow(10,c));
	            int r=(int)(N%Math.pow(10,c));
	             j=q+r; 
	           
	            if(j==n)
	                System.out.println("1");
	            else
	                System.out.println("0");
	     // }
	    t--;
	    }
	    	}

	

}
