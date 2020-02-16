    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100,j=0,i=0, n=c.length;
        while((i+k)%n != 0){
            i=(i+k)%n;
            energy -= (c[i]==0?1:3);
            System.out.println(energy);
        }
        energy -= (c[0]==0?1:3);
        return energy;
    }
