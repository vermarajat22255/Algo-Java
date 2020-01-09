import java.util.*;

class Solution {
    public static void main(String args[]){
        String S = "John Doe; Peter bej parker; John Evan Doe; Maria Jane Watson-Parker";
        String C= "example";
        String input[] = S.split("; ");
        String res="";
        Map<String, Integer> map = new LinkedHashMap<>();
        String fname;
        String lname;
        for(int i=0;i<input.length;i++) {
           String[] temp = input[i].split(" ");
           fname=temp[0];
           lname=temp[temp.length-1];
           lname=lname.replace("-", "");
           lname=lname.substring(0, Math.min(lname.length(), 8));
           if(map.get(fname+"."+lname)==null) {
              map.put(fname+"."+lname, 0);
           }
           else {
            map.put(fname+"."+lname+((map.get(fname+"."+lname))+1), (map.get(fname+"."+lname))+1);
           }
         }
         for(java.util.Map.Entry<String, Integer> result : map.entrySet()) {
           res += result.getKey() + "@"+C+".com; ";
         }
         System.out.print(res.toLowerCase());
   }
}

//________________________________________________USING HASH SET___________________________________________________________

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
