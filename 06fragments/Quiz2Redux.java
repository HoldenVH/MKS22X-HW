import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s, "");
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, 
			      String word, String part ){
	if(words.size()==0){
	    words.add("");
	}  
	if(word.length()>0){
	    help(words,word.substring(1),part);
	    help(words,word.substring(1),part+word.substring(0,1));
	    words.add(part+word.substring(0,1));
	}
    }
}
