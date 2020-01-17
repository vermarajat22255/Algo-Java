import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Main{

    public static void main(String []args){
    String arr[]= {"EAST", "WEST", "NORTH", "WEST"};
    LinkedList<String> Direction = new LinkedList<>(Arrays.asList(arr));
    while(dirRed(Direction)){}
    System.out.println(Direction);
    }

    
    public static String getOpposite(String s){
      if(s.equalsIgnoreCase("NORTH")) return "SOUTH";
      else if(s.equalsIgnoreCase("SOUTH")) return "NORTH";
      else if(s.equalsIgnoreCase("EAST")) return "WEST";
      else if(s.equalsIgnoreCase("WEST")) return "EAST";
      else return "TRUE";
    }
    
    public static boolean dirRed(LinkedList<String> Direction){
    boolean flag=false;

    for (int i=1;i<Direction.size();i++){
     if(getOpposite(Direction.get(i-1)).equalsIgnoreCase(Direction.get(i))){
        Direction.remove(i);
        if(!(Direction.get(i-1).isBlank()||Direction.get(i-1).isEmpty())) Direction.remove(i-1);
        flag=true;
     }
     }
    return flag;
    }
}
