import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StripeTracker{
    public static void main(String args[]){
        Server s = new Server();
        System.out.println(s.allocate("apibox"));
        System.out.println(s.allocate("apibox"));
        System.out.println(s.allocate("apibox"));
        System.out.println(s.allocate("apibox"));
        s.deAllocate("apibox2");
        System.out.println(s.allocate("apibox"));

        System.out.println(s.allocate("Jukebox"));

        System.out.println(s.allocate("Peepbox"));
        s.deAllocate("apibox1");

        System.out.println(s.allocate("apibox"));
        System.out.println(Server.server_mappings.get("apibox"));
    }
}
class Server{
    private int number;
    private String label;
    public static HashMap<String, ArrayList<Integer>> server_mappings = new HashMap<>();
    
    public Server(){}
    public Server(int number, String label){
        this.number = number;
        this.label = label;
    }
    public boolean equals(Server other){
        return this.label.equalsIgnoreCase(other.label) && Integer.compare(this.number, other.number) == 0;
    }
    public String toString(){
        return this.label+this.number;
    }

    public String allocate(String label){
        if(server_mappings.isEmpty() || !server_mappings.containsKey(label)){
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(1);  // add minimum number to list
            server_mappings.put(label, numbers);
            return label + numbers.get(0);
        }
        // add the minimum of that label to list
        ArrayList<Integer> existing  = server_mappings.get(label);
        int new_server_Num = getMin(existing);
        existing.add(new_server_Num);
        server_mappings.put(label, existing);
        return label+new_server_Num;
    }
    private int getMin(ArrayList<Integer> existing){
        Collections.sort(existing);
        for(int i=1; i<existing.size(); i++){
            if(existing.get(i-1) != i) return i;
        }
        return existing.size()+1;
    }
    public void deAllocate(String label){
        String number = label.trim().replaceAll("[^0-9]", "");
        label = label.trim().substring(0, label.length()-number.length());

        if(server_mappings.containsKey(label) && server_mappings.get(label).size()!=0){
            server_mappings.get(label).remove(server_mappings.get(label).indexOf(Integer.parseInt(number)));
        }
    }
}