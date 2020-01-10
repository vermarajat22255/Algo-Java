import java.util.*;

class Email {
    public static void main(String args[]){
        String S = "John Doe; Peter bej parker; John Evan Doe; Maria Jane Watson-Parker";
        String comp = "example";
        String input[] = S.replace("-","").split("; ");
        String res="";
        HashSet<String> hs  = new HashSet<>();

        for(int i=0;i<input.length;i++){
            int count =1;
            String fname[] = input[i].split(" ");
            String first = fname[0];
            String last = fname[fname.length-1];
            last = last.substring(0,Math.min(last.length(), 8));
            
            res = first+last+"@"+comp+".com";

            if(hs.contains(res)){
                res = first+last+count+"@"+comp+".com";
                hs.add(res);
                ++count;
            }
            else{
                hs.add(res);
            }
        }
        System.out.print(hs);
   }
}