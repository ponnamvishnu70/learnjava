package learnjava.practice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(value = Include.NON_EMPTY)
public class User extends ResourceSupport  implements Serializable {
	
	@Id
	@GeneratedValue
	private int pid;
	private String name;
	private int rank;
	@Transient
	private List<String> str;
	
	public List<String> getStr() {
		return str;
	}

	public void setStr(List<String> str) {
		this.str = str;
	}

	public User() {}
	
	public User(int id, String name, int rank) {
		super();
		this.pid = id;
		this.name = name;
		this.setRank(rank);
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
