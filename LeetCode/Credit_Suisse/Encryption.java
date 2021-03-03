/*

    floor(squareRoot(stringLength)) <= matrixRows <= matrixColumns <= ceil(squareRoot(stringLength))
    matrixRows x matrixColumns >= stringLength
    Choose the matrix with the smallest area.
    Print out the characters of the first column, then embed a space before printing out the following column, etc. 
    
    "coding" -> len = 6
*/
public class Encryption {
    public static void main(String[] args) {
        String input =  "its harder to read code than to write it";
        input = input.replace(" ", "");
        System.out.println(encrypt(input));
    }

    static String encrypt(String input) {
        if(input.trim().length() < 2) return "";
        input = input.replace(" ", "");
        return helper(input);
    }
    public static String helper(String input){
        int len = input.length();
        int row = (int) Math.floor(Math.sqrt(len));
        double max = Math.ceil(Math.sqrt(len));
        int col = (int)max;
        
        
        while( row * col < len && col <= max && row <= max ){
            if((row+1) <= col && (row +1) <= max){
                row++;
            }else{
                col++;
            }
        }
        String res = "";
        for(int j=0; j<col; j++){
            for(int i=j; i< len; i+=col){
                res+= input.charAt(i);
            }
            res+=" ";
        }
        return res;
    }
}
