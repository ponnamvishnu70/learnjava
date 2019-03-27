package learnjava.practice.fileandio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*s
 *  InputStream is used to read raw bytes, Reader is used to read text data
 * FileInputStream is meant for reading streams of raw bytes
 * such as image data. For reading streams of characters, consider using
 * FileReader
 * platform default encoding needs to be UTF-8.Changed it in eclipse for this program to give expected output 
 *
 *JAVA DOCS
 * For top efficiency, consider wrapping an InputStreamReader within a
 * BufferedReader
 * BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\AA0534\\Desktop\\input.txt"),
		        "UTF8"));
 *
 *<p> In general, each read request made of a Reader causes a corresponding
 * read request to be made of the underlying character or byte stream.  It is
 * therefore advisable to wrap a BufferedReader around any Reader whose read()
 * operations may be costly, such as FileReaders and InputStreamReaders.  For
 * example,
 *
 * <pre>
 * BufferedReader in
 *   = new BufferedReader(new FileReader("foo.in"));
 * </pre>
 *
 * will buffer the input from the specified file.  Without buffering, each
 * invocation of read() or readLine() could cause bytes to be read from the
 * file, converted into characters, and then returned, which can be very
 * inefficient.
 * */
public class FileReaderExample {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		try {
		 in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\AA0534\\Desktop\\input.txt"),"UTF8"));
		String currentLine = null ;
		while((currentLine =in.readLine()) != null) {
		System.out.println(currentLine);
		}
		}catch (Exception e) {
			
		}
		finally{
		 in.close();
		}
		}
	
	}
	

