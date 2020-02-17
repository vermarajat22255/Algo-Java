//BigInteger is a Java class which is used to hold a numerical value with more than 19 digits long, we use
//method like BigInteger.add(), multiply etc to perform operation on BigInteger numbers
// Note: we have a "ValueOf" method like we have for other classes to convert class variable to primitive or vice versa. 

static void extraLongFactorials(int n) {
        BigInteger b = new BigInteger("1");
        while(n>0){
            b = b.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(b);
    }
