package LeetCode;

import java.util.ArrayList;

public class Leet_VersionCompare {
        public int compareVersion(String version1, String version2) {
            String[] ar1 = version1.split("\\.");
            String[] ar2 = version2.split("\\.");
            
            ArrayList<String> al1 = new ArrayList<>();
            
            for(String x: ar1)
                al1.add(x);
            
            ArrayList<String> al2 = new ArrayList<>();
            
            for(String y: ar2)
                al2.add(y);
            
            while(al1.size() < al2.size()){
                al1.add("0");
            }
            while(al1.size() > al2.size()){
                al2.add("0");
            }
            int i=0;
            
            while(i < al1.size()){
                int x = Integer.parseInt(al1.get(i));
                int y = Integer.parseInt(al2.get(i));
                
                if(x > y) return 1;
                else if( x < y) return -1;
                i++;
            }
            return 0;
        }
}