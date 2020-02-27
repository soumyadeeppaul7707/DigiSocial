package com.sp.digisocial.profile.service;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.digisocial.profile.bean.Post;
import com.sp.digisocial.profile.fs.ZipFSPUser;
import com.sp.digisocial.profile.repo.PostRepository;

@Service
public class ProfileService {

	@Autowired
	public PostRepository postRepository;

	@Transactional
	public void fileUploadProcess(Post post) throws Throwable {
		String fileLocation = null;
		String fileName = null;

		// save blob object i.e.- image to a text file
		// E:\newstart\grand project\zipfs\
		try {
			Random rand = new Random();
			double rand_dub = rand.nextDouble();
			fileName = post.getFilename() + rand_dub + ".txt";
			fileLocation = "E:\\newstart\\grand project\\zipfs\\" + fileName;
			File myObj = new File(fileLocation);
			if (myObj.createNewFile()) {
				FileWriter fw = new FileWriter(fileLocation);
				fw.write(post.getBlobobject());
				fw.close();
				post.setImagefilename(fileName);
			}
			ZipFSPUser addFileToFilesystem = new ZipFSPUser();
			addFileToFilesystem.addFileToZipFileSystem(fileName);
			myObj.delete();
		} catch (Exception e) {
			System.out.println(e);
		}

		postRepository.save(post);
	}

}
