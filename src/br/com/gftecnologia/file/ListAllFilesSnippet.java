package br.com.gftecnologia.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListAllFilesSnippet {

	/**
	 * Recursively list all  the files in directory.
	 * 
	 * @param path the path to start the search from
	 * @return list of all files
	 */
	public static List<File> listAllFiles(String path) {
		var all = new ArrayList<File>();
		var list = new File(path).listFiles();

		if (list != null) {
			for (var f : list) {
				if (f.isDirectory()) {
					all.addAll(listAllFiles(f.getAbsolutePath()));
				} else {
					all.add(f.getAbsoluteFile());
				}
			}
		}

		return all;
	}
}
