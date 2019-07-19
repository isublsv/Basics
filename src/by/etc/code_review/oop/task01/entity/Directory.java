package by.etc.code_review.oop.task01.entity;

import java.util.ArrayList;
import java.util.List;

public class Directory {

	private String name;
	private List<File> files;

	public Directory(String name) {
		this.name = name;
		files = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addFile(File file){
		return files.add(file);
	}

	public boolean deleteFile(File file){
		return files.remove(file);
	}

	public void printFiles(){
		if (files.isEmpty()){
			System.out.println("The directory is empty!");
			return;
		}

		for (File file: files){
			System.out.println(file);
		}
	}

	@Override
	public String toString() {
		return "Directory{" + "name='" + name + '\'' + '}';
	}
}
