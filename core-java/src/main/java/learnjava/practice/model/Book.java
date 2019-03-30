package learnjava.practice.model;

import java.io.Serializable;

public class Book extends ParentBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 351656231413071535L;
	public String title;
	//Author won't be store
	public transient String author;
	public int edition;

	public Book(String title, String author, int edition) {

		this.title = title;
		this.author = author;
		this.edition = edition;
	}

}
