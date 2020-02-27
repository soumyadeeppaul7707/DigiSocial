package com.sp.digisocial.profile.fs;

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
		URI uri = URI.create("jar:file:/E:/newstart/grand project/zipfs/digisocialzipfs.zip");

		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			Path externalTxtFile = Paths.get("E:/newstart/grand project/zipfs/" + filename);
			Path pathInZipfile = zipfs.getPath("/" + filename);
			// copy a file into the zip file
			Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
