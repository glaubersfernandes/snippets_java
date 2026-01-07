package br.com.gftecnologia.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectorySnippet {

	/**
	 * Zip a complete directory.
	 * 
	 * @param srcDirectoryName The path to the directory to be zipped
	 * @param zipFileName The location and name of the zipped file.
	 * @throws IOException if an I/O error occurs
	 */
	public static void zipDirectory(String srcDirectoryName, String zipFileName) throws IOException {
		var srcDirectory = new File(srcDirectoryName);

		try (var fileOut = new FileOutputStream(zipFileName); var zipOut = new ZipOutputStream(fileOut)) {
			zipFile(srcDirectory, srcDirectory.getName(), zipOut);
		}

	}

	/**
	 * Utility function which either zips a single file, or recursively calls itself for
	 * a directory to traverse down to the files contained within it.
	 * 
	 * @param fileToZip The file as a resource
	 * @param fileName The actual name of the file
	 * @param zipOut The output stream to which all data is being written
	 * @throws IOException if an I/O error occurs
	 */
	public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {

		if (fileToZip.isHidden()) {
			return;
		}

		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zipOut.putNextEntry(new ZipEntry(fileName));
				zipOut.closeEntry();
			} else {
				zipOut.putNextEntry(new ZipEntry(fileName + "/"));
				zipOut.closeEntry();
			}

			var children = fileToZip.listFiles();

			for (var childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}

			return;
		}

		try (var fis = new FileInputStream(fileToZip)) {
			var zipEntry = new ZipEntry(fileName);
			zipOut.putNextEntry(zipEntry);
			var bytes = new byte[1024];
			var length = 0;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
		}
	}
}
