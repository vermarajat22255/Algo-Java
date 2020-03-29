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
