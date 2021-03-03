class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        
        if(sx == tx){
            return ty - sy > 0 && (ty - sy) % sx == 0; // ty has to be bigger than sy
        }else if(sy == ty){
            return tx - sx > 0 && (tx - sx) % sy == 0; // tx has to be bigger than sx
        }
        return helper(sx, sy,tx,ty);
    }
    public boolean helper(int sx, int sy, int tx, int ty){
        if(sx == tx  && sy == ty ) return true;
        if(sx > tx || sy > ty) return false;
        return helper(sx, sy, tx-ty, ty) || helper(sx, sy, tx, ty-tx);
    }
}
/*
sx 9
sy 10
tx 9
ty 19

(tx,ty) = (3, 5)
(sx, sy) = (1, 1)

Top Down
                    (1, 1)
            /                   \
        (2, 1)                (1, 2)
        /    \               /      \
    (3, 1)   (2,3)      (3,2)       (1, 3)
    / \        /  \      /   \      /    \
(4,1) (3,4) (2,5) (5,3) (5,2)(3,5) (4,3)(1,4)

Bottom Up

	          (3, 5)
		/      \
	     (-2, 5)   (3,2)
		      /   \
	 	   (1,2)  (3,-1)
	          /    \
	      (-1, 2) (1, 1)
    
*/
