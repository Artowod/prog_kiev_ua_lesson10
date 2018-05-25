package ua.prog.java.lesson10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vocabulary {
	private String pathToVocabulary;
	private Map<String, String> vocabulary = new HashMap<>();

	public Vocabulary() {

	}

	public Vocabulary(String pathToVocabulary) {
		super();
		this.pathToVocabulary = pathToVocabulary;
	}

	public String getPathToVocabulary() {
		return pathToVocabulary;
	}

	public void setPathToVocabulary(String pathToVocabulary) {
		this.pathToVocabulary = pathToVocabulary;
	}

	public Map<String, String> getVocabulary() {
		return vocabulary;
	}

	public void addNewWordToVocab(String engWord, String ukrWord) {

	}

	public void addNewWordToVocabFile(String newEnglWord, String newUkrWord) {
		try (FileWriter fw = new FileWriter(pathToVocabulary, true); PrintWriter a = new PrintWriter(fw)) {
			a.println(newEnglWord + "=" + newUkrWord);
		} catch (IOException e) {
			System.out.println("ERROR FILE WRITE");
		}
		createVocabFromFile();
	}

	private boolean checkNewWordsPairFormat(String checkedString) {
		if (checkedString.isEmpty()) {
			return false;
		}
		if (checkedString.indexOf("=") == -1) {
			return false;
		}
		if (checkedString.indexOf("=") != checkedString.lastIndexOf("=")) {
			return false;
		}
		if (checkedString.indexOf("=") == 0 || checkedString.lastIndexOf("=") == checkedString.length() - 1) {
			return false;
		}
		return true;
	}

	public void addWordsToVocabFileFromConsole() {
		System.out.println("Adding words to vocabulary from Console:");
		System.out.println("Correct form must be: \"english word=ukrainian word\" ;");
		System.out.println("For instance: you=ти ;");
		System.out.println("For exit please type digit \"0\";");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String s = "";
		System.out.print("Please type a pair of words:");
		for (; !(s = sc.nextLine()).equals("0");) {
			if (!checkNewWordsPairFormat(s)) {
				System.out.println("Incorrect format. Please try again.");
			} else {
				String[] splittedPair = s.split("=");
				addNewWordToVocabFile(splittedPair[0], splittedPair[1]);
			}
			System.out.print("Please type a pair of words:");
		}
		System.out.println(s);
	}

	public void createVocabFromFile() {
		String lineFromVocabFile;
		try (BufferedReader bufReader = new BufferedReader(new FileReader(pathToVocabulary))) {
			for (; (lineFromVocabFile = bufReader.readLine()) != null;) {
				vocabulary.put(lineFromVocabFile.split("=")[0], lineFromVocabFile.split("=")[1]);
			}
		} catch (IOException ex) {
			System.out.println("IO Error in getEnglTextFromFile method.");
		}
		System.out.println("Words in Vocabulary: " + vocabulary.size());
	}

}
