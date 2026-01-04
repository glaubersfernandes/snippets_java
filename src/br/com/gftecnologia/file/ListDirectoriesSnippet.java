package br.com.gftecnologia.file;

import java.io.File;

public class ListDirectoriesSnippet {

	/**
	 * List directories.
	 * 
	 * @param path the path where to look
	 * @return array of File
	 */
	public static File[] listDirectories(String path) {

		return new File(path).listFiles(File::isDirectory);
	}
}
