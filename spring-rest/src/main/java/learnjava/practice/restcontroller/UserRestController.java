package learnjava.practice.restcontroller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import learnjava.practice.entity.User;
import learnjava.practice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	// to add return links we have to extend out entity class with resource support
	// then use linkto static method to form a url and call add method to add urls
	@GetMapping("/{id}")
	public ResponseEntity<User> user(@PathVariable("id") int id) {
		Link withSelfRel = linkTo(UserRestController.class).slash(id).withSelfRel();
		List<User> users = ControllerLinkBuilder.methodOn(this.getClass()).allUsers();
		User user = userService.getUserById(id);
		user.add(linkTo(users).withRel("getallusers"));
		user.add(withSelfRel);
		ResponseEntity<User> ruser = new ResponseEntity<User>(user, HttpStatus.OK);
			ruser=null;
			ruser.getBody();
		return ruser;
	}

	@GetMapping("/all")
	public List<User> allUsers() {
		return userService.getAllUsers();
	}

	/*
	 * Add this json to BODY in postman request
	 * {"name":"vishnupost","rank":30} Make request as post request
	 * content-type :application/json we can take all the body in the request
	 * using @RequestBody
	 */

	// return 201 for when new resource is created
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		// ResponseEntity<User>
		User savesUser = userService.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savesUser.getId())
				.toUri();
		ResponseEntity<User> responseEntity = ResponseEntity.created(uri).build();
		return responseEntity;
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity replaceUser(@RequestBody User user,@PathVariable int id) {
		user.setPid(id);//setting id is important
		userService.replace(user);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@PatchMapping("/partial/{id}")
	public User modifyUser(@RequestBody User user,@PathVariable("id") int id) {
		user.setPid(id);
		Optional<User> optional = userService.modify(user);
		return optional.get(); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
