package com.demo.io.filesOperations;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;


/**
 * @version 1.1 2012-05-31
 * @author Cay Horstmann
 */
public class FindDirectories{

	/**
	 * 遍历路径下的所有 文件&文件夹
	 * @param dir
	 * @throws IOException
	 */
	public void getFileName(String dir) throws IOException{
		Path path = Paths.get(dir);
		DirectoryStream<Path> entries = Files.newDirectoryStream(path);
		for(Path entry : entries){
			System.out.println(entry.getFileName());
			System.out.println(entry.getParent());
			System.out.println(entry.getRoot());
			System.out.println(entry.getNameCount());
			System.out.println("----------");
		}

	}
	
	public void FindDirectories(String arg) throws IOException{
		Path dir = Paths.get(arg);
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>(){

			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{               
				if (attrs.isDirectory()) 
					System.out.println(file);
				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{
				return FileVisitResult.CONTINUE;
			}
		});
	}


	public static void main(String[] args) throws IOException {
		FindDirectories test = new FindDirectories();
		
		test.getFileName("/Users/DamianZhou/Movies/Vedio");
	}
}
