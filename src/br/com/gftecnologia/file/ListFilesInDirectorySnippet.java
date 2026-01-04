package br.com.gftecnologia.file;

import java.io.File;

public class ListFilesInDirectorySnippet {

	/**
	 * List files in directory.
	 * 
	 * @param folder the path where to look
	 * @return array of File
	 */
	public static File[] listFilesInDirectory(String folder) {

		return new File(folder).listFiles(File::isFile);
	}
}
