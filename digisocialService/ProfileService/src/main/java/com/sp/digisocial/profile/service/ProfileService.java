package com.sp.digisocial.profile.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	public void fileUploadProcessProfilePicture(Post post) throws Throwable {
		String fileLocation = null;
		String fileName = null;

		// save blob object i.e.- image to a text file
		// E:\newstart\grand project\zipfs\
		try {
			// File file = new File("E:\\newstart\\grand project\\zipfs");
			// file.mkdirs();
			new File("/home/soumyadeep/Desktop/grand_project/zipfs/").mkdirs();
			Random rand = new Random();
			double rand_dub = rand.nextDouble();
			fileName = post.getImagefilename() + rand_dub + ".txt";
			fileLocation = "/home/soumyadeep/Desktop/grand_project/zipfs/" + fileName;
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

	@Transactional
	public Post fileFetchProcessProfilePicture(Post post) throws Throwable {
		List<Post> posts = new ArrayList<Post>();
		posts = postRepository.findByUsernameAndIspostOrderByUploadtimeDesc(post.getUsername(), false);
		try {

			ZipFSPUser fetchFileFromFilesystem = new ZipFSPUser();
			for (Post p : posts) {
				File myObj = fetchFileFromFilesystem.fetchFileFromFileSystem(p.getImagefilename());
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
					p.setBlobobject(myReader.nextLine());
				}
				myReader.close();
				myObj.delete();
			}

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return posts.get(0);
	}

	@Transactional
	public void fileUploadProcessPost(Post post) throws Throwable {
		String fileLocation = null;
		String fileName = null;

		if (post.getImagefilename() != null) {
			try {
				new File("/home/soumyadeep/Desktop/grand_project/zipfs/").mkdirs();
				Random rand = new Random();
				double rand_dub = rand.nextDouble();
				fileName = post.getImagefilename() + rand_dub + ".txt";
				fileLocation = "/home/soumyadeep/Desktop/grand_project/zipfs/" + fileName;
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
		}
		postRepository.save(post);
	}

	@Transactional
	public List<Post> fileFetchProcessPost(Post post) throws Throwable {
		List<Post> posts = new ArrayList<Post>();
		posts = postRepository.findByUsernameAndIspostOrderByUploadtimeDesc(post.getUsername(), true);
		try {

			ZipFSPUser fetchFileFromFilesystem = new ZipFSPUser();
			for (Post p : posts) {
				if (p.getImagefilename() != null) {
					File myObj = fetchFileFromFilesystem.fetchFileFromFileSystem(p.getImagefilename());
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						p.setBlobobject(myReader.nextLine());
					}
					myReader.close();
					myObj.delete();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return posts;
	}
}
