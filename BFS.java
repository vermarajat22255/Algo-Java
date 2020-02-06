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
class BFS{
    public static void main(String args[]){
        Graph g = new Graph(4);
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
        bfsTraverse(g.adj, 4, 2);

    }
    static void bfsTraverse(int adj[][], int n, int start){
        Queue<Integer> q  = new LinkedList<>();
        LinkedHashSet<Integer> visited = new LinkedHashSet<>();
        q.add(start);
        visited.add(start);
        while(q.peek()!=null){
            int ele = q.poll();
            System.out.println("->"+ele);
            for(int i=0;i<n;i++){
                if(adj[ele][i] == 1){
                    if(!visited.contains(i)){
                        visited.add(i);
                        q.add(i);
                    }
                }
            }
        }
    }
}