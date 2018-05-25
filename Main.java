package ua.prog.java.lesson10;

public class Main {

	private static void taskOneTwo() {
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

	private static void taskThree() {
		ObjectOneRepetitions objectOne = new ObjectOneRepetitions("Tank Oplot", 2018);
		ObjectOneRepetitions objectTwo = new ObjectOneRepetitions("Star Trek", 2017);
		ObjectTwoRepetitions objectThree = new ObjectTwoRepetitions("HULK", 2018, true);
		ObjectTwoRepetitions objectFour = new ObjectTwoRepetitions("Lokki", 2018, false);
		String strOne = "Hello";
		String strTwo = "Bye";
		Integer intOne = 101010;

		Object[] checkedArray = new Object[] { objectOne, objectOne, objectTwo, objectTwo, objectOne, objectThree,
				objectThree, objectFour, strOne, strTwo, strTwo, intOne, intOne, intOne };

		System.out.println("Correct result has to be like this:");
		System.out.println(
				"Tank Oplot-3, Star Trek-2, HULK-2, Lokki-1, String \"Hello\"-1, String \"Bye\"-2, Integer 101010-3");
		Repetitions repetitions = new Repetitions(checkedArray);
		repetitions.countRepetitionsNumber();
		System.out.println(repetitions.toString());
	}

	public static void main(String[] args) {

		// taskOneTwo();
		taskThree();

	}

}
