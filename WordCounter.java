import java.io.*;
import java.util.*;

public class WordCounter {

	public static void main(String[] args) throws IOException {
		
		// Inputs the file into a scanner
		File file = new File ("Macbeth.rtf");
		Scanner fileIn = new Scanner(file);
		
		// Creates ArrayLists to store the words in
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> counter = new ArrayList<Integer>();
		
		// Read through the file
		while(fileIn.hasNext()) {
			
			// This gets the next word
			String nextWord = fileIn.next();
			
			//Sees if we already have this word
			if(words.contains(nextWord)) {
				
				// If the word exists in the list, get the index of the word and add 1 to it
				int index = words.indexOf(nextWord);
				counter.set(index, counter.get(index) + 1);
				
				// Sort the list
				Collections.sort(counter);
				
			}	else	{
				
				// If the word doesn't exist, add it to the list and set its index to 1
				words.add(nextWord);
				counter.add(1);
				
				// Sort the list
				Collections.sort(counter);
				
			}
			
		} // end while
		
		// Close the file (for safety reasons)
		fileIn.close();
		
		// Print the findings
		for(int i=1; i < words.size(); i++) {
			
			if(counter.get(i) > 1) {
				
				// Prints the word at index 1, gets how many times it counted by getting the indext of its count
				System.out.println(words.get(i) + " occurred " + counter.get(i) + " times.");
			
			}	else	{
				
				// Prints the word at index 1, gets how many times it counted by getting the indext of its count
				System.out.println(words.get(i) + " occurred " + counter.get(i) + " time.");
				
			}
			
		} // end for loop
		

	} // end main()

} // end WordCounter
