    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int amount=0;
        for(int i=0;i<bill.size();i++){
            if(i!=k){
                amount+=bill.get(i);
            }
        }

        if(amount/2 != b){
            System.out.println( b-(amount/2));
        }else{
            System.out.println("Bon Appetit");
        }
    }
