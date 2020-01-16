    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int totalAp=0,totalOr=0;
    for(int i=0;i<apples.length;i++){
        apples[i] +=a;
    }
    for(int i=0;i<oranges.length;i++){
        oranges[i] +=b;
    }

    for(int c: apples){
        if(c>=s && c<=t)
        totalAp++;
    }
    for(int c: oranges){
        if(c>=s && c<=t)
        totalOr++;
    }

    System.out.println(totalAp);
    System.out.println(totalOr);
    }
