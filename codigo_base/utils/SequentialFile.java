package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SequentialFile <T extends SequentialFileReadable> {

	private File file;
	private Scanner scan;
	private String separator;

	public SequentialFile(String fileName, String separator) throws FileNotFoundException {
		this.file = new File(fileName);
		this.scan = new Scanner(file);
		this.separator = separator;
	}

	public void read(T t) {
		String[] data = scan.nextLine().split(separator);
		t.readData(data);
	}
	
	public void skip() {
		 scan.nextLine();
	}

	public void close() {
		scan.close();
	}
	
	public boolean isEndOfFile() {
		return !scan.hasNextLine();
	}

}
