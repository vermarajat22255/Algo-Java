import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /*
        0 1 2 3
    0   0 1 1 0  
    1   0 0 1 0
    2   1 0 0 1
    3   0 0 0 1
    */
    static int graph[][] = new int[][] 
    {   {0,1,1,0},
        {0,0,1,0},
        {1,0,0,1},
        {0,0,0,1}
    };

    static HashSet<Integer> visited = new HashSet<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        bfs(2, 0, graph);
    }

    public static void bfs(int i, int j, int graph[][]) {

        queue.add(i);

        while (!queue.isEmpty()) {
            System.out.print(" --> " + queue.peek());
            i = queue.peek();
            visited.add(queue.poll());
            
            for(int k=0; k<graph.length; k++){
                    if(graph[i][k] == 1 && !visited.contains(k)){
                        queue.add(k);
                    }
            }
        }
    }
}
