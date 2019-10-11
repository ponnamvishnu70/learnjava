package learnjava.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import learnjava.practice.entity.User;

@Service
public interface UserService {
	
	public User getUserById(int id);

	User saveUser(User user);
	List<User> getAllUsers();

	
}
