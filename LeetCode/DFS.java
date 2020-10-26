import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    static int graph[][] = new int[][] 
    {   {0,1,1,0},
        {0,1,1,0},
        {1,0,0,0},
        {0,0,0,1}
    };

    static HashSet<Integer> visited = new HashSet<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        for(int i=0;i<graph.length; i++){
                dfs(i, graph);
        }
    }

    static void dfs(int node, int graph[][]) {
        if(!visited.contains(node))System.out.println(" --> "+node);
        visited.add(node);
        for(int k=0; k<graph.length; k++){
            if(graph[node][k] == 1 && !visited.contains(k)){
                dfs(k, graph);
            }
        }
    }
}
