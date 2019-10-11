package swd20.C4.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);
}