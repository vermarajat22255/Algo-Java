// Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String meet ="NO";
        if(x1<x2 && v2>v1 && x1!=x2) return meet;
        
        while(x1 <= x2){
            if(x1 != x2){
                x1 = x1 + v1;
                x2 = x2+ v2;
            }
            else{
                meet = "YES";
                break;
            }
        }
        return meet;
    }

kangaroo 2 was always ahead if speed of 2 > 1 they wont meet, else we will jump them until x1 meet or cross x2
