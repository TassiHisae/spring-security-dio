package dio.diospringsecurity.init;

import dio.diospringsecurity.model.User;
import dio.diospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User user = repository.findByUsername("admin");

        if(Objects.isNull(user)){
            user = new User()
                    .setName("ADMIN")
                    .setUsername("admin")
                    .setPassword("master123");

            user.getRoles().add("MANAGERS");

            repository.save(user);
        }

        user = repository.findByUsername("user");

        if(Objects.isNull(user)){
            user = new User()
                    .setName("USER")
                    .setUsername("user")
                    .setPassword("user123");

            user.getRoles().add("USERS");

            repository.save(user);
        }
    }

}
