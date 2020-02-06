import java.util.*;
class Graph{
    int n;
    int adj[][];
    public Graph(){
        System.out.println("creating graph...");
    }
    public Graph(int n){
        this.n = n;
        adj = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j] = 0;
            }
        } 
    }
    public boolean addEdge(int u, int v){
        if(n>u && n>v){
            adj[u][v] = 1;
            return true;
        }
        return false;
    }
    public void printGraph(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
class DFS{
    static LinkedHashSet<Integer> visited = new LinkedHashSet<>();
    static Graph g = new Graph(4);   
    public static void main(String args[]){
        int start =2;
        // g.addEdge(0, 1);
        // g.addEdge(1, 3);
        // g.addEdge(2, 0);
        // g.addEdge(2, 1);
        // g.addEdge(3, 2);
        // g.addEdge(3, 3); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        g.printGraph();

        dfsTraverse(start);
        System.out.println(visited);
    }
    static void dfsTraverse(int adj[][], int n){
        
        visited.add(n);
        for(int i=0;i<4;i++){
            if(adj[n][i] == 1 && !visited.contains(i)){
                visited.add(i);
                dfsTraverse(adj, i);
            }
        }
    }
    static void dfsTraverse(int start){
        dfsTraverse(g.adj, start);
    }
}