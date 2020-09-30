package celestia.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BasicFileWriter {
	
	
	/**
	 * basic write a string buffer to a file
	 * 
	 * @param fileString
	 * @param uri
	 */
	@SuppressWarnings("resource")
	public static void writeIt(StringBuilder fileString, String uri){
		File file = new File(uri);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException(ioe.getMessage());
			}
		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getAbsoluteFile());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException(ioe.getMessage());
		}
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		try {
			bufferedWriter.write(fileString.toString());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException(ioe.getMessage());
		}
		try {
			bufferedWriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException(ioe.getMessage());
		}
	}

}
