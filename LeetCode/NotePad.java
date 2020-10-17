import java.util.ArrayList;
import java.util.Stack;

/*
A text editor is a type of computer program that edits plain text.
Your task is to simulate the working process of a text editor which can handle five types of operations:
    INSERT <text> - add <text> to the end of the current text, where <text> consists of at most 20 English letters,
    DELETE - erase the last character of the current text (if the current text is empty, does nothing),
    COPY <index> - copy the substring of the current text starting from <index> and spanning until the end (if <index> is out of bounds copies an empty string), i.e. sets the clipboard value equal to the given substring,
    PASTE - add the last copied text to the end of the current text (if the last copied text is empty, does nothing)
    UNDO - undo the last successful INSERT, DELETE or PASTE operation (if there is nothing to undo, does nothing).

You are given operations, an array of strings where each is an operation of one of the five types above. Your task is to find the resulting text after performing the given operations.

NOTE: An operation is considered successful if the text in editor is changed after the operation is completed. In particular, deleting the last character of an empty text and pasting an empty string are unsuccessful operations.

Example

    For operations = ["INSERT Code", "INSERT Signal", "DELETE", "UNDO"], the output should be newTextEditor(operations) = "CodeSignal".
        Initially the text is empty,
        After the "INSERT Code" operation, the text is "Code",
        After the "INSERT Signal" operation, the text is "CodeSignal",
        After the "DELETE" operation, the last character is removed, so the text is "CodeSigna",
        After the "UNDO" operation, the DELETE operation is undone, so the text is "CodeSignal",
        So the final string is "CodeSignal".

*/
public class NotePad {
  public static void main(String[] args) {
    String operations[] = new String[]{"INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam"};
    NotepadImplementation notepad = new NotepadImplementation();
    for(int i=0; i<operations.length;i++){
        String curr_operation = operations[i];
        if(curr_operation.indexOf("INSERT") == 0){
            
            notepad.insert(curr_operation.split(" ")[1]);
        
        }else if(curr_operation.indexOf("COPY") == 0){
            
            notepad.copy(Integer.parseInt(curr_operation.split(" ")[1]));
        
        }else if(curr_operation.equals("UNDO")){

            notepad.undo();

        }else if(curr_operation.equals("PASTE")){

            notepad.paste();
        }else{
            
            notepad.delete();
        }
    }

    System.out.println("final Answer "+ notepad.current_text);
    }  
}
class NotepadImplementation{
    public String current_text;
    public String clipboard;
    public Stack<String> history;

    public NotepadImplementation(){
        this.current_text = "";
        this.clipboard = "";
        this.history = new Stack<String>();
    }
    public void insert(String text){
        this.history.push(this.current_text);
        this.current_text += text;              
    }
    public void delete() {
        if(this.current_text.length()>1){
            this.history.push(this.current_text);
            this.current_text = this.current_text.substring(0, this.current_text.length()-1);
        }
    }
    public void copy(int index){
        if(index >= this.current_text.length()) {
            this.clipboard = "";
            return;
        }
        this.clipboard = this.current_text.substring(index);
    }
    public void paste(){
        if(this.clipboard.isEmpty()) return;
        this.history.push(this.current_text);
        this.current_text += this.clipboard;
    }
    public void undo(){
        if(this.history.isEmpty()) return;
        this.current_text = this.history.peek();
    }
} // clipboard ["Da"] history ["DaDaDaD","DaDaDaDa","DaDaDa","DaDa","Da","",""] text = "DaDaDaDaaam"
/*
For operations = ["INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam"], the output should be newTextEditor(operations) = "DaDaDaDaaam".
	
        Initially the text is empty,
		
        After the "INSERT Da" operation, the text is "Da",
		
        After the "COPY 0" operation, the clipboard is set to "Da", the text is left unchanged,
		
        After the "UNDO" operation, the INSERT operation is undone, so the text is "",
		
        After the "PASTE" operation, the text "Da" is inserted from the clipboard, so the editor text is changed to "Da",
		
        After the "PASTE" operation, the text "Da" is inserted from the clipboard, so the editor text is changed to "DaDa",
		
        After the "COPY 2" operation, the clipboard is set to "Da", the editor text is left unchanged,
		
        After the "PASTE" operation, the text "Da" is inserted, so the editor text is changed to "DaDaDa",
		
        After the "PASTE" operation, the text "Da" is inserted, so the editor text is changed to "DaDaDaDa",
		
        After the "DELETE" operation, the last character is removed, so the text is "DaDaDaD",
		
        After the "INSERT aaam" operation, the text is "DaDaDaDaaam",
	
        So the final editor text is "DaDaDaDaaam". 
*/