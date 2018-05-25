package ua.prog.java.lesson10;

public class Main {

	public static void main(String[] args) {

		/* task 1,2 */

		Vocabulary englToUkrVocabulary = new Vocabulary("C:/Java/Lesson10/Vocabulary.txt");
		englToUkrVocabulary.createVocabFromFile();
		// englToUkrVocabulary.addNewWordToVocabFile("no","í³");
		englToUkrVocabulary.addWordsToVocabFileFromConsole();
		System.out.println("Current vocabulary: " + englToUkrVocabulary.getVocabulary());
		Translator englToUkrTranslate = new Translator("C:/JAVA/Lesson10/English.in", "C:/JAVA/Lesson10/Ukrainian.out",
				englToUkrVocabulary);
		englToUkrTranslate.translate();
		englToUkrTranslate.storeTranslatedTextToFile();
	}

}
