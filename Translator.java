package ua.prog.java.lesson10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translator {
	private Vocabulary instanceOfVocabulary;
	private String englishFilePath;
	private String translatedFilePath;
	private List<String> englishTextByLines = new ArrayList<>();
	private String[] translatedTextByLines;
	private Map<String, String> vocabulary = new HashMap<>();

	public Translator() {

	}

	public Translator(String englishFilePath, String translatedFilePath, Vocabulary instanceOfVocabulary) {
		this.englishFilePath = englishFilePath;
		this.translatedFilePath = translatedFilePath;
		this.instanceOfVocabulary = instanceOfVocabulary;
	}
	
	

	public String getEnglishFilePath() {
		return englishFilePath;
	}

	public void setEnglishFilePath(String englishFilePath) {
		this.englishFilePath = englishFilePath;
	}

	public String getTranslatedFilePath() {
		return translatedFilePath;
	}

	public void setTranslatedFilePath(String translatedFilePath) {
		this.translatedFilePath = translatedFilePath;
	}

	public Map<String, String> getVocabulary() {
		return vocabulary;
	}

	private List<String> pullEnglTextFromFile() {
		List<String> englTextFromFile = new ArrayList<>();
		String lineFromFile;
		try (BufferedReader bufReader = new BufferedReader(new FileReader(englishFilePath))) {
			for (; (lineFromFile = bufReader.readLine()) != null;) {
				englTextFromFile.add(lineFromFile);
			}
		} catch (IOException ex) {
			System.out.println("IO Error in getEnglTextFromFile method.");
		}
		return englTextFromFile;
	}

	public void storeTranslatedTextToFile() {
		try (PrintWriter a = new PrintWriter(translatedFilePath)) {
			for (int i = 0; i < translatedTextByLines.length; i++) {
				a.println(translatedTextByLines[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error in the module storeTranslatedTextToFile");
		}
	}

	private String getTranslatedWord(String englWord) {
		String endSymbol = "";
		String translatedWord;
		String possibleEndSymbol = "; . , : ! ? - +";
		String key;
		endSymbol = englWord.substring(englWord.length() - 1);
		if (possibleEndSymbol.contains(endSymbol)) {
			key = englWord.substring(0, englWord.length() - 1);
			String value = vocabulary.get(key);
			translatedWord = (value == null) ? englWord : value;
			translatedWord += endSymbol;
			return translatedWord;
		} else {
			String value = vocabulary.get(englWord);
			translatedWord = (value == null) ? englWord : value;
			return translatedWord;
		}
	}

	public void translate() {
		vocabulary = instanceOfVocabulary.getVocabulary();
		englishTextByLines = pullEnglTextFromFile();
		System.out.println("Englist text: \n" + englishTextByLines.toString());
		translatedTextByLines = new String[englishTextByLines.size()];
		for (int j = 0; j < englishTextByLines.size(); j++) {
			String eachEnglLine = englishTextByLines.get(j);
			String[] splittedEnglLineToWords = eachEnglLine.split(" ");
			String translatedWords = "";
			for (int i = 0; i < splittedEnglLineToWords.length; i++) {
				translatedWords += getTranslatedWord(splittedEnglLineToWords[i]) + " ";
			}
			translatedTextByLines[j] = translatedWords;
		}
		System.out.println("Translated to Ukr:");

		for (String s : translatedTextByLines) {
			System.out.println(s);
		}
	}
}
