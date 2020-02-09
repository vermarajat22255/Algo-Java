    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int liked=0,com=liked,share=5;
        for(int i=0;i<n;i++){
            liked = share/2;
            com += liked;
            share = liked*3;
        }
        return com;
    }
