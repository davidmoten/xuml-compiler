package moten.david.uml.xuml.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import moten.david.uml.xuml.model.compiler.util.StringUtil;

public class SqlReservedWords {

	private static SqlReservedWords instance;

	public synchronized static SqlReservedWords getInstance() {
		if (null == instance) {
			instance = new SqlReservedWords();
		}
		return instance;
	}

	private Set<String> reservedWords = new HashSet<String>();

	private SqlReservedWords() {
		try {
			String all = StringUtil.readString(getClass().getResourceAsStream(
					"sql-reserved-words.txt"));
			String[] words = all.split("\n");
			for (String word : words)
				reservedWords.add(word.trim());
		} catch (IOException e) {
			throw new Error(e);
		}
	}

	public boolean isReservedWord(String word) {
		for (String s : reservedWords) {
			if (s.equalsIgnoreCase(word.trim()))
				return true;
		}
		return false;
	}

	public Set<String> getReservedWords() {
		return reservedWords;
	}

}
