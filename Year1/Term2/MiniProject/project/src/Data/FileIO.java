package Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Investment.*;

public class FileIO {

	public static Investment Investment = null;

	public static void Read() {
		FileInputStream fis = null;
		ObjectInputStream oin = null;
		try {
			fis = new FileInputStream("data");
			oin = new ObjectInputStream(fis);
			FileIO.Investment = (Investment) oin.readObject();
		}

		catch (Exception en) {
			FileIO.Investment = new Investment();
		}

		finally {
			try {
				if (oin != null)
					oin.close();
				if (fis != null)
					fis.close();
			} catch (IOException en) {
			}

		}
	}

	public static void Write() {
		try {
			FileOutputStream fout = new FileOutputStream("data");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(FileIO.Investment);
			out.flush();
			fout.close();
		} catch (Exception en) {

		}
	}
}
