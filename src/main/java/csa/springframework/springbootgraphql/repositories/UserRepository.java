package csa.springframework.springbootgraphql.repositories;

import csa.springframework.springbootgraphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

}
