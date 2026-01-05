package br.com.gftecnologia.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadLinesSnippet {

	/**
	 * Read file as list of strings.
	 * 
	 * @param filename the filename to read from
	 * @return list of strings
	 * @throws IOException if an I/O error occurs
	 */
	public static List<String> readLines(String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}
}
