package dio.diospringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome ro My Spring Boot Web API";
    }

    //Sem Configure Adapter
//    @GetMapping("/users")
//    @PreAuthorize("hasAnyRole('MANAGERS','USERS')")
//    public String users(){
//        return "Authorized user";
//    }
//
//    @GetMapping("/managers")
//    @PreAuthorize("hasRole('MANAGERS')")
//    public String managers(){
//        return "Authorized manager";
//    }

    //Com Configure Adapter
    @GetMapping("/users")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/managers")
    public String managers(){
        return "Authorized manager";
    }
}
