class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet(wordList);
        if(!words.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int x=0; x<size; x++){
                String current_word = queue.poll();
                char curr_arr[] = current_word.toCharArray();
                for(int i=0; i<curr_arr.length; i++){
                    char temp = curr_arr[i];
                    for(char ch ='a'; ch<='z'; ch++){
                        if(curr_arr[i] == ch) continue;
                        curr_arr[i] = ch;
                        
                        String new_word = String.valueOf(curr_arr);
                        
                        if(new_word.equals(endWord)){
                            return level+1;
                        }
                            
                        if(words.contains(new_word)){
                            queue.offer(new_word);
                            words.remove(new_word);
                        }
                    }
                    curr_arr[i]= temp;
                }
            }
            ++level;
        }
        return 0;
    }
}
