package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

	public static void main(String[] args) throws IOException {
		String filename = "/Users/minhthutran/eclipse-workspace/OtherProjects/test.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		StringBuffer sf = new StringBuffer();
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		for (byte b : inputBytes) {
			sf.append(b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}
}