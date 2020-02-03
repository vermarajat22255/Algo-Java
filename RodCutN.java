import java.util.Random;

class RodCutN{
    public static void main(String args[]){
        
//        int price[] = {-1, 1, 5, 8, 9, 10, 17, 17, 20};
        int price[] = new int[150];
        int n = price.length;
        int r[] = new int[n+1];
        for(int i=0;i<n;i++) {
            price[i] =  new Random().nextInt(100);
            //System.out.println(price[i]);
            r[i] = Integer.MIN_VALUE;
            r[i+1] = Integer.MIN_VALUE;
        }

        //System.out.println(rodCut(price,n));

        System.out.println("Top down ->"+memoRodCut(price,n,r));
        //System.out.println("Bottoms up ->"+rodBottom(price,n,r));
                
    }
    static int rodCut(int p[], int n){
        if( n ==1) return 0;
        int max = -1;
        for(int i=1;i<n;i++){
            max = Math.max(max, p[i]+rodCut(p, n-i));
        }
        return max;
    }
    static int memoRodCut(int p[], int n, int r[]){
        int max = Integer.MIN_VALUE;
        if(r[n]>=0 ) return r[n];

        if(n == 1) return 0;        
        else{
            for(int i=1;i<n;i++){
             max = Math.max(max, p[i]+memoRodCut(p, n-i,r));
            }
        }
        r[n] = max;
        return max;
    }
    static int rodBottom(int p[],int n,int r[]){
        r[0] = 0;
        for(int i=1;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<=i;j++){
                max = Math.max(max, p[j] +r[i-j]);
            }
            //System.out.println(max);
        r[i] = max;
        }
    return r[n-1];
    }
}