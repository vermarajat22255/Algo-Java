import java.util.*;
class DynamicSeq{
    public static void main(String args[]){
        //  String s1= "horseback";
        //  String s2 = "snowflake";
        String s2 = "spanking"; //
        String s1 = "amputation";
        // String s1 = "pioneer";
        // String s2 = "springtime";
        
        longestSeq(s1, s2);

    }
    public static void longestSeq(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        char b[][] = new char[m+1][n+1];
        int c[][] = new int[m+1][n+1];

        for(int i=0;i<m+1;i++) {c[i][0] = 0;} //b[i][0]="0";}
        for(int i=0;i<n+1;i++) {c[0][i] = 0;}// b[0][i]="0";}
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 'd';
                }else{
                    if(c[i-1][j]>=c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 'u';
                    }else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 'l';
                   }
                }
            }
        }
        for(int k=0;k<=m;k++){
            for(int j=0;j<=n;j++)
            System.out.print(b[k][j]+" ");
            System.out.println();
        }
        System.out.println("___________________");
        
        for(int k=0;k<m+1;k++){
            for(int j=0;j<n+1;j++)
            System.out.print(c[k][j]+" ");
            System.out.println();
        }
        printSeq(b,s1,m,n);
    }

    
    static void printSeq(char b[][], String s1, int m, int n){
        if(m== 0 && n ==0) {
            return;
        }
        if(b[m][n]=='d'){
            printSeq(b, s1, m-1, n-1);
            System.out.print(s1.charAt(m-1));
        } else {
            if(b[m][n]=='u'){
                printSeq(b, s1, m-1, n);
            } else {
                printSeq(b, s1, m, n-1);                
            }
        }
    }
    // static void print(String b[][], String s1, int m, int n){
    //     String x = b[m][n];
	// 	String answer = "";
	// 	while (x != "0") {
	// 		if (b[m][n] == "d") {
	// 			answer = s1.charAt(m-1) + answer;
	// 			m--;
	// 			n--;
	// 		} else if (b[m][n] == "l") {
	// 			n--;
	// 		} else if (b[m][n] == "u") {
	// 			m--;
	// 		}
	// 		x = b[m][n];
	// 	}
	// 	System.out.println("ans: "+answer);
    // }
}
