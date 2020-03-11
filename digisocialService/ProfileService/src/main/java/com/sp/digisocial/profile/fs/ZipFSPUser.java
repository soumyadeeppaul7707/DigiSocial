package com.sp.digisocial.profile.fs;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class ZipFSPUser {
	public void addFileToZipFileSystem(String filename) throws Throwable {
		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		//URI uri = URI.create("jar:file:/E:/newstart/grand%20project/zipfs/digisocialzipfs.zip"); // for windows
		URI uri = URI.create("jar:file:/home/soumyadeep/Desktop/grand_project/zipfs/digisocialzipfs.zip"); // for linux
		
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			//Path externalTxtFile = Paths.get("/home/soumyadeep/Desktop/grand project/zipfs/" + filename); //for windows
			Path externalTxtFile = Paths.get("/home/soumyadeep/Desktop/grand_project/zipfs/" + filename); //for linux
			Path pathInZipfile = zipfs.getPath("/" + filename);
			// copy a file into the zip file
			Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public File fetchFileFromFileSystem(String filename) throws Throwable {

		Path zipFile = Paths.get("/home/soumyadeep/Desktop/grand_project/zipfs/digisocialzipfs.zip");
		//String fileName = filename;
		Path outputFile = Paths.get("/home/soumyadeep/Desktop/grand_project/zipfs/" + filename);

		try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile, null)) {
			Path fileToExtract = fileSystem.getPath(filename);
			Files.copy(fileToExtract, outputFile);
		}
		return new File(outputFile.toUri());

	}

}
