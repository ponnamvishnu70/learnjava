package learnjava.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learnjava.practice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
