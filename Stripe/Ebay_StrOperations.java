public class Ebay_StrOperations {
    public static void main(String[] args) {
        String[] operations = new String[]{"L","L", "C0", "L","C3" };
        mutate(operations);
    }
    static void mutate(String[] operations){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<10; i++){
            result.append("0");
        }
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("L")){
                for(int j=0; j<result.length(); j++){
                    if(result.charAt(j) == '0'){
                        result.setCharAt(j, '1');
                        break;
                    }
                }
            }else{
                int index = Integer.parseInt(operations[i].split("")[1]);
                result.setCharAt(index, '0');
            }
        }
        System.out.println(result.toString());
    }
}
