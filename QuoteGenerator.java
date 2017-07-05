import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuoteGenerator {

	public static Quote[] fileToArray(String fileName){
		Scanner file = null;

		try{
			file = new Scanner(new File(fileName));
		}
		catch (IOException exception){
			exception.printStackTrace();
		}

		// first line of file is the number of quotes the file contains
		int numQuotes = file.nextInt();
		// returned quote array will contain as many quotes as the file contains,
			// i.e. numQuotes
		Quote[] quoteArray = new Quote[numQuotes];
		int i = 0;
		String quote = "";
		String speaker = "";
		String source = "";
		// while the file still has lines to read and not all quotes are yet in the quote array
		while (file.hasNextLine() && i<numQuotes){
			// skip over each line in file separating quotes
			file.nextLine();
			// read in quote, speaker, source
			quote = file.nextLine();
			speaker = file.nextLine();
			source = file.nextLine();
			// create a new quote object from read-in quote, speaker, & source
				// and put at index i in quote array
			quoteArray[i] = new Quote(quote, speaker, source);
			// increment index for next loop through while loop
			i++;
		}

		return quoteArray;
	}

	public static Quote grabRandomQuote(Quote[] quoteArray){
		Random randomIndex = new Random();
		// grab a random int somewhere within the range 0 to numQuotes
		int quoteIndex = randomIndex.nextInt(quoteArray.length);
		// return the quote at that random index
		return quoteArray[quoteIndex];
	}

	public static void printQuote(Quote quote){
		System.out.println(quote.theQuote);
		System.out.println(quote.theSpeaker);
		System.out.println(quote.theSource);
	}

	public static void main(String[] args){
		Quote[] quoteArray = fileToArray("ImposterQuotes.txt");
//		for (Quote quote : quoteArray){
//			System.out.println("HERE IS A QUOTE: ");
//			printQuote(quote);
//		}
		Quote randomQuote = grabRandomQuote(quoteArray);
		printQuote(randomQuote);
	}

}
