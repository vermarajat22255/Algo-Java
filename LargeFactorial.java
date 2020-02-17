    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger b = new BigInteger("1");
        while(n>0){
            b = b.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(b);
    }
// we use BigInteger class to add a big integer that can handle variable as long as 150 digits. we use methods to perform operations on this class
