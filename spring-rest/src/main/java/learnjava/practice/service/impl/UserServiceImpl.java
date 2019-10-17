package learnjava.practice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learnjava.practice.entity.User;
import learnjava.practice.repository.UserRepository;
import learnjava.practice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserById(int id) {
		// getOne is lazy method that returns proxy obj.
		// using getting one is causing Json issues
		// adding additional hibernate obj and handlers
		// User one = userRepository.getOne(id);
		Optional<User> one = userRepository.findById(id);
		return one.get();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void replace(User user) {		
		userRepository.save(user);
	}

	@Override
	public Optional<User> modify(User user) {
	return	userRepository.findById(user.getPid()).map( x -> {
			x.setName(user.getName());
			return userRepository.save(x);

		});

	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
