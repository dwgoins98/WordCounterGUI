import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WordCounterGUI extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Word Counter GUI");

        VBox.vBox = new VBox();
        vBox.getChildren().addAll();

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<WordCounter> getWords()  {
        ObservableList<WordCounter> words = FXCollections.observableArrayList();
        words.add(new WordCounter())

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
        //---------------------------------------------
        //---------------End WordCounter---------------
    }

}