package learnjava.practice.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import learnjava.practice.entity.User;
import learnjava.practice.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping("/user/{id}")
	public User user(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users")
	public List<User> users() {
		return userService.getAllUsers();
	}

	/*
	 * Add this json to BODY in postman request
	 * {"id":33,"name":"vishnupost","rank":30} Make request as post request
	 * content-type :application/json we can take all the body in the request
	 * using @RequestBody
	 */

	//return 201 for when new resource is created
	@PostMapping("/user")
	public ResponseEntity<User> user(@RequestBody User user) {
		// ResponseEntity<User>
		User savesUser = userService.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savesUser.getId()).toUri();
		ResponseEntity<User> responseEntity = ResponseEntity.created(uri).build();
		return responseEntity;
	}
}
