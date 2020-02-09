/* This was particularly interesting because you have to think different possible cases
* It took me while to think and map all the possible cases in the problem, which was intresting
* Learning-> in such kind of problems start thinking of all possible cases
*/

// Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        int leftchoc=m%n,chair=-1;
        if(leftchoc==0){
            if(s==1){
                chair = n;
            }else{
                chair = s-1;
            }
        }else{
            if(s==1){
                chair = leftchoc;
            }else{
                System.out.print("case4");
                chair = (s+leftchoc-1)%n==0?(s+leftchoc-1):(s+leftchoc-1)%n;
            }
        }
        return chair;
    }
