import java.util.Arrays;
import java.util.PriorityQueue;

public class Leet_253_MeetingRooms{
    public static void main(String args[]){
        int intervals[][] = {{2,15},{36,45},{9,29},{16,23},{4,9}}; //{{0,30}, {5,10}, {15,20}};
        Arrays.sort(intervals, (arr1, arr2)-> Integer.compare(arr1[0], arr2[0]));
        System.out.print("\nNumber of meeting rooms required -> "+getRooms(intervals)); 
    }
    public static int getRooms(int intervals[][]){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<intervals.length; i++){
            if(heap.isEmpty()){
                heap.add(intervals[i][1]);
            }else{
                if(heap.peek() > intervals[i][0]){
                    heap.add(intervals[i][1]);
                }else{
                    heap.poll();
                    heap.add(intervals[i][1]);
                }
            }
        }
        return heap.size();
    }
}