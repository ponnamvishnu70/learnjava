package learnjava.practice.genericsenumsserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import learnjava.practice.model.Book;

//Serialization mean able to store state of the object 
//De-Serialization mean able to get state of object from stored data.
//Only non-static can be serialized
//to make a class serializable we need to implement serializable interface
//Serializable - marker interface ...To this to let JVM know this class should be able to serialize and de-serialize
//https://www.geeksforgeeks.org/object-serialization-inheritance-java/
public class SerializationExample {

	private static final long serialVersionUID = -7712724328991436030L;

	public static void main(String[] args) {
		Book serializeBook = new Book("Java", "Vishnu", 3);
		serializeBook.k=20;
		String filename = "file.txt"; // This will created under core-java directory
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		FileInputStream fin = null;
		ObjectInputStream in = null;
		try {
			// Serialization
			fout = new FileOutputStream(filename);
			out = new ObjectOutputStream(fout);
			out.writeObject(serializeBook);
			System.out.println("serialized");

			Book deserializeBook = null;

			// Deserialization
			fin = new FileInputStream(filename);
			in = new ObjectInputStream(fin);
			deserializeBook = (Book) in.readObject();

			System.out.println("deserialized");
			System.out.println("title = " + deserializeBook.title);
			System.out.println("author = " + deserializeBook.author);
			System.out.println("editon = " + deserializeBook.edition);
			System.out.println("editon = " + deserializeBook.k);
		} catch (IOException ex) {
		} catch (ClassNotFoundException ex) {
		} finally {

			try {
				fin.close();
				fout.close();
				in.close();
				out.close();
			} catch (IOException e) {
			}

		}

	}

}
