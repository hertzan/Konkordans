import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File inFile = new File("C:\\Users\\iWuT\\Dropbox\\KTH\\ADK\\Konkordans\\ut");
		File outFile = new File("C:\\Users\\iWuT\\Dropbox\\KTH\\ADK\\Konkordans\\testoutput.txt");
		
		try {
			Setup setup = new Setup(inFile, outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
