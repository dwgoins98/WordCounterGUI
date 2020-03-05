public ObservableList<WordCounter> getWords()  {
        ObservableList<WordCounter> wordsFX = FXCollections.observableArrayList();
        

        // -------------------------------------
        // ---------From WordCounter------------
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
                
                wordsFX.add(new WordCounter(words, counter));
                return wordsFX;
				
			}	else	{
				
				// If the word doesn't exist, add it to the list and set its index to 1
				words.add(nextWord);
				counter.add(1);
				
				// Sort the list
                Collections.sort(counter);
                
                wordsFX.add(new WordCounter(words, counter));
                return wordsFX;
			}
			
		} // end while
		
		// Close the file (for safety reasons)
        fileIn.close();
        //---------------------------------------------
        //---------------End WordCounter---------------
    }