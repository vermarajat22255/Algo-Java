class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String charMap[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if(digits.length() == 0) return result;
        
        result.add("");
        
        for(int i=0; i< digits.length(); i++){
            
            while(result.peek().length() == i){
                
                String s=result.remove();
                
                for(char x: charMap[Character.getNumericValue(digits.charAt(i))].toCharArray() ){
                    
                    result.add(s+x);
                }
            }
        }
        return result;
    }
}
// try 2 awesome result
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        String result[] = new String[]{""};
        int i=0;
        while( i < digits.length()){
            temp = multiply(temp, words(digits.charAt(i)));
            i++;
        }
        return Arrays.asList(result);
    }
    String[] words(char num){
        switch(num){
                case '2': return new String[]{"a","b","c"};
                case '3': return new String[] {"d", "e","f"};
                case '4': return new String[] {"g","h","i"};
                case '5': return new String[] {"j","k","l"};
                case '6': return new String[] {"m","n","o"};
                case '7': return new String[] {"p","q","r","s"};
                case '8': return new String[] {"t","u","v"};
                case '9': return new String[] {"w","x","y","z"};
                default : return new String[] {};
        }
    }
    String[] multiply(String[] arr1, String arr2[]){
        String res[] = new String[arr1.length  * arr2.length];
        int j=0;
        for(String ch1: arr1){
            for(String ch2: arr2){
                res[j++] = ch1+""+ch2;
            }
        }
        return res;
    }
}