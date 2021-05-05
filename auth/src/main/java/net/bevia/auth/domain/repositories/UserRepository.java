package net.bevia.auth.domain.repositories;

import net.bevia.auth.domain.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
