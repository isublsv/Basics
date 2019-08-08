package by.epam.code_review.module5.oop.task01.utils;

import by.epam.code_review.module5.oop.task01.entity.Directory;
import by.epam.code_review.module5.oop.task01.entity.File;

public class DirectoryUtils {

	private Directory directory;

	public DirectoryUtils(Directory directory) {
		this.directory = directory;
	}

	public boolean addFile(File file){
		return directory.getFiles().add(file);
	}

	public boolean deleteFile(File file){
		return directory.getFiles().remove(file);
	}

	public void printFiles(){
		if (directory.getFiles().isEmpty()){
			System.out.println("The directory is empty!");
			return;
		}

		for (File file: directory.getFiles()){
			System.out.println(file);
		}
	}
}
