 // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int date = 0;
        if(year == 1918) return "26.09.1918";
        if(year>1918){
            if((year%4 ==0 && year%100 !=0) || year%400 == 0){
                date = 12;
            }
            else{
                date =13;
            }
        }
        else{
            if(year%4==0){
                date = 12;
            }else{
                date =13;
            }
        }
        String d = date+".09."+year;
    return d;
    }
