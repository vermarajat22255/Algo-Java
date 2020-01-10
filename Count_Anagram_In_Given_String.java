import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
static int total =0;
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        ArrayList<String> al = new ArrayList<String>();
        total =0;
        for(int i=0;i<s.length();i++){
           for(int j=i+1;j<=s.length();j++){
               al.add(s.substring(i,j));
            } 
        }
        total = checkAnagrams(al);
        
        return total;
    }
    static int checkAnagrams(ArrayList al){
        
//        System.out.print("al"+al);

        for(int i=0;i<al.size();i++){
            for(int j=i+1;j<al.size();j++){
                String a = (String)al.get(i);
                String b = (String)al.get(j);
            
                if(a.length() == b.length()){
                    char a1[] = new char[a.length()];
                    char a2[] = new char[b.length()];
                    a1 = a.toCharArray();
                    a2 = b.toCharArray();
                    
                    Arrays.sort(a1);
                    Arrays.sort(a2);
                    
                    a = Arrays.toString(a1);
                    b = Arrays.toString(a2);

                    if(a.equalsIgnoreCase(b)){
                        total++;
                    }
                }
            }
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
