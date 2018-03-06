package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.User;

/**
 * Created by kpetkov on 05.03.18.
 */

public interface UserRepository extends JpaRepository<User, Long> {


}
