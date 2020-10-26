/*
if the representative of nodes are different(checking recursively)
    -> subtract number of ditinct unions
    -> else continue
*/
class UnionFinder{
    int friend_circle;
    int representative[];
    
    public UnionFinder(int n){
        this.friend_circle = n;
        this.representative = new int[n];
        for(int i=0;i<n;i++)
            this.representative[i] = i;
    }
    public void union(int i, int j){
        int a = find(i);
        int b = find(j);
        if(a != b){
            // set representative of big one to be small one as both of them are in union
            this.representative[b] = a;
            this.friend_circle--;
        }
    }
    public int find(int i){
        if(this.representative[i] == i) return i;
        return find(this.representative[i]);
    }
    public int getFriends_circle(){
        return this.friend_circle;
    }
    
}
class Leet547_FriendUnion {
    public int findCircleNum(int[][] M) {
        UnionFinder obj = new UnionFinder(M.length);
        for(int i=0;i<M.length; i++){
            for(int j=0;j<M.length;j++){
                if(i != j && M[i][j] == 1){
                    obj.union(i, j);
                }
            }
        }
        return obj.getFriends_circle();
    }
}