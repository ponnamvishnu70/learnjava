package learnjava.practice.fileandio;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

/*
 * 1byte = 8bits
 * 
 * A char in Java is 2 bytes large .But doesn't need to be 2 byte long every time *  
 *  many encodings  only reserve 1 byte for every character (ASCII)  
 *  
 *  If the platform(Windows/Linux) default encoding is a 1-byte encoding
 *  it can  convert that 1 byte to a single character.
 *  -->tried to read foreign language txt file and it failed because these character are not defined in ASCII and have to use UTF-8 encoding need 2bytes
 *  ASCII is now a subset of UTF-8. UTF-8 is backwards compatible with ASCII
 * FileInputStream can read  a byte(1byte =8bits=ASCII character) of data at once
 * ****From Java DOCS
 * FileInputStream is meant for reading streams of raw bytes
 * such as image data. For reading streams of characters, consider using
 * FileReader
 * 
 * ****
 * First, InputStreamReader can handle all input streams, not just files. 
 * Other examples are network connections, classpath resources and ZIP files.
 * Second, FileReader does not allow you to specify an encoding and instead uses the plaform default encoding, which makes it pretty much useless as using it will result in corrupted data when the code is run on systems with different platform default encodings.
 * In short, forget that FileReader exists.
 * */

public class FileIOStream {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = null;
		try {
			/*fin = new FileInputStream("C:\\Users\\AA0534\\Desktop\\input.txt");
			System.out.println(fin.available());
			System.out.println(Character.BYTES);
			System.out.println(Charset.defaultCharset());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.getChannel().position());*/
			System.out.println(Long.parseLong(""));
		} catch (Exception e) {
		} finally { 
			//fin.close();
		}

	}

}
