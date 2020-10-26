package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leet_FizzBuzz {
    public static void main(String args[]) {
        System.out.println(fizzBuzz(31));
    }
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> al = new ArrayList<>();
        // one(al, n);
        // two(al, n);
        // three(al,1, n);
        // four(al, n);
        five(al, n);
        return al;
    }
    public static  ArrayList<String> one(ArrayList<String> al, int n){
        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0)
                al.add("FizzBuzz");
            else if (i % 3 == 0)
                al.add("Fizz");
            else if (i % 5 == 0)
                al.add("Buzz");
            else
                al.add(i + "");
        }
        return al;
    }
    public static ArrayList<String> two(ArrayList<String> al, int n){
        String current = "";
        for(int i=1; i<=n; i++){
            if(i%3 == 0) current+="Fizz";
            if(i%5 == 0) current+="Buzz";
            if(i%3 != 0 && i%5 != 0){
                current+=i;
            }
            al.add(current);
            current="";
        }
        return al;
    }
    public static ArrayList<String> three(ArrayList<String> al,int start, int n){
        if(start >= n) return al;
        if (start % 3 == 0 && start % 5 == 0)
            al.add("FizzBuzz");
        else if (start % 3 == 0)
            al.add("Fizz");
        else if (start % 5 == 0)
            al.add("Buzz");
        else
            al.add(start + "");
        three(al, start+1, n);
        return al;
    }
    public static ArrayList<String> four(ArrayList<String> al, int n){
        for(int i=1; i<n; i++){
            al.add(i+"");
        }
        for(int i=3; i<=n; i+=3){
            al.set(i-1,"Fizz");
        }
        for(int i=5; i<=n; i+=5){
            al.set(i-1,"Buzz");
        }       
        for(int i=15; i<=n; i+=15){
            al.set(i-1,"FizzBuzz");
        }
        return al;
    }
    public static ArrayList<String> five(ArrayList<String> al, int n){
        int fizz=0, buzz=0, i=1;
        while(i<=n){
            if (fizz ==3 && buzz == 5){
                al.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }
            else if (fizz == 3 ){
                al.add("Fizz");
                fizz = 0;
            }
            else if (buzz == 5){
                al.add("Fizz");
                buzz = 0;
            }
            fizz++;
            buzz++;
            al.add(i + "");
            i++;
        }
        return al;
    }
}