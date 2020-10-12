/*
        
         hot
        /   \
      lot---dot
       /      /  
     log     /
    /   \   /
  cog--- dog
        
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Leet127_WordLadder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            // Step 1 -- for all the possible transformation of the current word
            // we keep adding it to queue
            int size = queue.size();
            // important point here, dont put queue.size in for loop it will increase loopo to next level
            // when more word are added
            for(int k=0; k<size;k++){
                
                String curr_str  = queue.poll();
                char curr_word[] = curr_str.toCharArray();

                for(int i=0; i<curr_word.length; i++){
                    char original_char = curr_word[i];
                    // try new characters
                    for(char ch='a'; ch<='z'; ch++){
                        if(curr_word[i] == ch) continue;

                        curr_word[i] = ch;
                        String new_word = String.valueOf(curr_word);

                        if(new_word.equals(endWord)) return level+1;
            
                        // Add all the possible word made from the first word in the queue
                        // and keep iterating the generated word to add more possible word
                        if(set.contains(new_word)){
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                    }
                    // done trying restore the word
                    curr_word[i] = original_char; 
                }
            }
            // above loop will generate words for same level
            ++level;
        }
        return 0;
    }
}