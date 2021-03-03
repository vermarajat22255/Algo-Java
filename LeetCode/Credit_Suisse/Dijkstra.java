import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
Single source algorithm 
based on assumptions that there are no negative weight and no negative weight cycle

for every vertx v we relax all edges going out of v

 */
public class Dijkstra {
    static int graph[][] = { 
        { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
    };
    public static void main(String[] args) {
        System.out.println(dijkstra(graph, 0)); 
    }
    public static int takeMinDistance(int dist[], boolean[] visited) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < graph.length; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public static int dijkstra(int graph[][], int node) {
        int total_nodes = graph.length;
        boolean visited[] = new boolean[total_nodes];

        int s[] = new int[total_nodes];
        Arrays.fill(s, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        s[0] = 0;

        // while we have not visited every node
        // relax all outgoing edges from current node

        for (int i = 0; i < graph.length-1; i++) {
            int u = takeMinDistance(s, visited);
            visited[u] = true;
            for(int j=0; j<graph[i].length; j++){
                if(!visited[j] && graph[u][j] != 0 && s[u] != Integer.MAX_VALUE && s[u]+ graph[u][j] < s[j]){
                    
                    s[j] = s[u]+ graph[u][j];
                }
            }
        }
        System.out.println(Arrays.toString(s));
        
        return 1;
    }
}
