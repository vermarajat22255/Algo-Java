import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leet609_FileSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> mappings = new HashMap<>();
        ArrayList<List<String>> results = new ArrayList<>();
        /*
         * created mappings like 
         * abcd -> root/a/1.txt 
         *      -> root/c/3.txt
         * efgh -> root/a/2.txt 
         */

        for (int j = 0; j < paths.length; j++) {
            String info[] = paths[j].split(" ");
            for (int i = 1; i < info.length; i++) {
                String x = info[i];
                String curr_key = x.substring(x.indexOf("(") + 1, x.indexOf(")"));
                if (!mappings.containsKey(curr_key)) {
                    ArrayList<String> path = new ArrayList<>();
                    path.add(info[0] + "/" + x.substring(0, x.indexOf("(")));
                    mappings.put(curr_key, path);
                } else {
                    ArrayList<String> path = mappings.get(curr_key);
                    path.add(info[0] + "/" + x.substring(0, x.indexOf("(")));
                    mappings.put(curr_key, path);
                }
            }
        }

        // System.out.println(mappings);
        for (ArrayList<String> al : mappings.values()) {
            if (al.size() > 1)   // check duplicates
                results.add(al);
        }
        return results;
    }
}