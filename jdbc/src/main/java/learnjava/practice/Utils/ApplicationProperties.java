package learnjava.practice.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
	private static Properties p;
	static {
		p = new Properties();
		FileInputStream inStream = null;
		try {
			 inStream = new FileInputStream("C:\\properties\\application.properties");
			p.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inStream.close();
			} catch (IOException e) {}
		}
	}

	public static Properties getProperties() {
		return p;
	}

}
