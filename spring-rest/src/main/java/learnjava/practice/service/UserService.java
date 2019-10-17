package learnjava.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import learnjava.practice.entity.User;

@Service
public interface UserService {
	
	public User getUserById(int id);

	User saveUser(User user);
	List<User> getAllUsers();

	public void replace(User user);

	public Optional<User> modify(User user);

	public void delete(int id);

	
}
