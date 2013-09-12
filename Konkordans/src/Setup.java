import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import org.omg.CORBA.portable.InputStream;

public class Setup {

	private Kattio kat;

	public Setup(File inFile, File outFile) throws FileNotFoundException {

		DataInputStream in = new DataInputStream(new FileInputStream(inFile));
		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				outFile));

		kat = new Kattio(in, out);

		try {
			setup(inFile, outFile);
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
	}

	private void setup(File inFile, File outFile) throws FileNotFoundException {
		// RandomAccessFile input = new RandomAccessFile(inFile, "r");
		// RandomAccessFile output = new RandomAccessFile(outFile, "rw");

		String str;
		String lastPrefix = null;
		String prefix;
		int index;
		int hash;

		while (kat.hasMoreTokens()) {
			str = kat.getWord();
			index = kat.getInt();

			try {
				prefix = str.substring(0, 3);
			} catch (IndexOutOfBoundsException e) {
				prefix = str;
			}

			hash = calcHash(prefix);
			
			if (!prefix.equals(lastPrefix)) {
				lastPrefix = prefix;
				// lägg till i hashtabell
			}
			// lägg till i binärsökningsfil
		}
	}

	private int calcHash(String prefix) {
		char first = prefix.charAt(0);
		char second = 0;
		char third = 0;

		try {
			second = prefix.charAt(1);
			third = prefix.charAt(2);

		} catch (IndexOutOfBoundsException e) {
			// do nothing, already handled above
		}

		return first + second * 30 + third * 900;
	}
}
