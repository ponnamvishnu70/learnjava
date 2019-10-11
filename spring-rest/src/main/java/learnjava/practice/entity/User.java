package learnjava.practice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int rank;
	
	public User() {}
	
	public User(int id, String name, int rank) {
		super();
		this.id = id;
		this.name = name;
		this.setRank(rank);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
