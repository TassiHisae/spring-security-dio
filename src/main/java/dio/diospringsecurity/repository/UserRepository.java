package dio.diospringsecurity.repository;

import dio.diospringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select u From User u Join Fetch u.roles Where u.username = (:username)")
    public User findByUsername(@Param("username") String username);
}
